package org.test.board.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.board.entities.BoardData;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>{
}
