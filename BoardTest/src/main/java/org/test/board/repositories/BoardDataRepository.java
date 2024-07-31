package org.test.board.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.test.board.entities.BoardData;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
}
