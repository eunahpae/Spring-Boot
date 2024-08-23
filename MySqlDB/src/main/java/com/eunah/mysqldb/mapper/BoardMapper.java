package com.eunah.mysqldb.mapper;

import com.eunah.mysqldb.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    int boardCount();

    List<Board> getList();

    Board getBoard(int boardId);

    void uploadBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Long board);
}
