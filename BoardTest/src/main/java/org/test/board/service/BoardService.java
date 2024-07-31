package org.test.board.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.test.board.controllers.RequestBoard;
import org.test.board.entities.BoardData;
import org.test.board.repositories.BoardDataRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDataRepository boardDataRepository;
    //등록
    public void register(RequestBoard form) {
        BoardData boardData = new ModelMapper().map(form,BoardData.class);
        boardDataRepository.saveAndFlush(boardData);
    }
    //목록
    public List<BoardData> list() {

        return boardDataRepository.findAll(Sort.by(Sort.Direction.DESC, "seq"));
    }
    //게시글 자세히보기
    public BoardData detail(Long seq){
        return boardDataRepository.findById(seq).orElse(null);
    }
    //수정
    public void update(RequestBoard form) {
        Long seq = form.getSeq();
        BoardData boardData = null;
        if(seq != null){
            boardData = boardDataRepository.findById(seq).orElse(null);
            if(boardData != null){
                boardData.setTitle(form.getTitle());
                boardData.setContent(form.getContent());
                boardData.setWriter(form.getWriter());
            }
        }
        if (boardData == null) boardData = new ModelMapper().map(form, BoardData.class);
        boardDataRepository.saveAndFlush(boardData);


    }
    public void delete(Long seq) {
        boardDataRepository.deleteById(seq);
    }
}
