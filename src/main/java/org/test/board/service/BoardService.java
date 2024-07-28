package org.test.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.test.board.entities.BoardData;
import org.test.board.repositories.BoardDataRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDataRepository boardDataRepository;
    //등록
    public void register(BoardData boardData) {
        boardDataRepository.save(boardData);
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
    public void update(BoardData boardData) {
        boardDataRepository.save(boardData);
    }
    public void delete(Long seq) {
        boardDataRepository.deleteById(seq);
    }
}
