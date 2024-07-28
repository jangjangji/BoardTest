package org.test.boardTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.test.board.entities.BoardData;
import org.test.board.repositories.BoardDataRepository;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class DbTest {

    @Autowired
    private BoardDataRepository boardDataRepository;
    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        BoardData boardData = BoardData.builder()
                .title("장성준")
                .content("테스트")
                .build();

        boardDataRepository.saveAndFlush(boardData);
    }
    @Test
    void test() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        System.out.println(item);;
    }
    @Test
    void test2() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        item.setTitle("(수정)장성준");
        boardDataRepository.saveAndFlush(item);
        System.out.println(item);
    }
}
