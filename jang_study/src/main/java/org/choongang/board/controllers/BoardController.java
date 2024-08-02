//package org.choongang.board.controllers;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BoardController {
//    @Controller
//    @RequestMapping("/board")
//    @RequiredArgsConstructor
//    public class BoardController {
//        private final BoardDataRepository boardDataRepository;
//        private final BoardDataSaveService boardDataSaveService;
//        private final BoardInfoService boardInfoService;
//
//
//        @GetMapping("/list")
//        public String list(Model model) {
//            List<BoardData> items = boardDataRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
////        List<BoardData> items = IntStream.rangeClosed(1,10)
////                        .mapToObj(i->BoardData.builder()
//////                                .seq((long)i)
////                                .title("제목"+i)
////                                .content("내용"+i)
////                                .author("작성자"+i)
////                                .build()).toList();
////        boardDataRepository.saveAllAndFlush(items);
////        items = boardDataRepository.findAll();
//            model.addAttribute("items", items);
//            commonProcess("", model);
//            setPageTitle("게시판 목록",model);
////        model.addAttribute("addCss","list");
//            return "board/list";
//        }
//
//        @GetMapping("/write")
//        public String write(@ModelAttribute BoardPost item, Model model) {
//            commonProcess("write", model);
//            setPageTitle("게시판 쓰기",model);
//            return "board/write";
//        }
//
//        @PostMapping("/save")
//        public String save(@Valid BoardPost item, Errors errors, Model model) {
//            String mode = item.getSeq() == null ? "write" : "update";
//            commonProcess(mode, model);
//            if (errors.hasErrors()) {
//                return "board/" + mode;
//            }
//
//            boardDataSaveService.post(item);
//            return "redirect:/board/list";
//        }
//
//        @GetMapping("/update/{seq}")
//        public String update(@PathVariable("seq") long seq, Model model) {
//            commonProcess("update", model);
//            Optional<BoardData> boardData = boardDataRepository.findById(seq);
//            setPageTitle("게시글 수정",model);
//            if (boardData.isPresent()) {
//                BoardPost boardPost = new ModelMapper().map(boardData.get(), BoardPost.class);
//                model.addAttribute("boardPost", boardPost);
//                return "board/update";
//            } else {
//                return "redirect:/board/list";
//            }
//        }
//
//        @PostMapping("/delete/{seq}")
//        public String delete(@PathVariable("seq") long seq) {
//            Optional<BoardData> boardData = boardDataRepository.findById(seq);
//            if (boardData.isPresent()) {
//                boardDataRepository.delete(boardData.get());
//                boardDataRepository.flush();
//                return "redirect:/board/list";
//            }
//            return "redirect:/board/list";
//        }
//
//        @GetMapping("/view/{seq}")
//        public String view(@PathVariable("seq") long seq, Model model) {
//            BoardData boardData = boardInfoService.get(seq);
//            model.addAttribute("boardData", boardData);
//            setPageTitle("게시글 보기",model);
//            commonProcess("view", model);
//            return "board/view";
//        }
//
//        private void commonProcess(String mode, Model model) {
//            List<String> addCss = new ArrayList<>();
//            List<String> addScript = new ArrayList<>();
//            addCss.add("style");
//            addCss.add("list");
//
//            if (mode.equals("write") || mode.equals("update") || mode.equals("view")) {
//                addCss.add("form");
//            }
//
//            model.addAttribute("addCss", addCss);
//            model.addAttribute("addScript", addScript);
//        }
//        private void setPageTitle(String title, Model model){
//            model.addAttribute("pageTitle", title);
//        }
//    }
//
//}