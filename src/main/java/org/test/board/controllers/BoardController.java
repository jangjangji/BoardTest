package org.test.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.test.board.entities.BoardData;
import org.test.board.repositories.BoardDataRepository;
import org.test.board.service.BoardService;

import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private final BoardService boardService;
    @Autowired
    private BoardDataRepository boardDataRepository;


    @GetMapping("/detail/{seq}")
    public String detail(@PathVariable("seq") Long seq, Model model) {
        model.addAttribute("boardData", boardService.detail(seq));
        return "board/detail";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("boardData",boardService.list());
        return "board/list";
    }
    @GetMapping("/register")
    public String register(@ModelAttribute RequestBoard form){
        return "board/register";
    }



    @PostMapping("/register")
    public String registerPs(@Valid RequestBoard form, Errors errors){
        if(errors.hasErrors()){
            return "board/register";
        }
        boardService.register(form);
        return "redirect:/board/list";

    }
    @GetMapping("/update/{seq}")
    public String updateGet(@ModelAttribute RequestBoard board,@PathVariable("seq") Long seq, Model model) {
        BoardData update = boardDataRepository.findById(seq).orElse(null);
        board.setSeq(update.getSeq());
        board.setTitle(update.getTitle());
        board.setContent(update.getContent());
        board.setWriter(update.getWriter());

        return "board/update";
    }

    @PostMapping("/update")
    public String updatePost(@Valid RequestBoard form, Errors errors) {
        if(errors.hasErrors()){
            return "board/update";
        }
        BoardData boardData = new ModelMapper().map(form,BoardData.class);
        boardService.update(form);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") Long seq) {

        boardService.delete(seq);
        return "redirect:/board/list";
    }
}
