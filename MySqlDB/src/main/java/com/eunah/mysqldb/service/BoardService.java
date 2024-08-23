package com.eunah.mysqldb.service;

import com.eunah.mysqldb.domain.Board;
import com.eunah.mysqldb.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class BoardService {

    private final BoardMapper boardMapper;

    public int boardCount() {
        return boardMapper.boardCount();
    }

    public List<Board> boardList() {
        return boardMapper.getList();
    }

    public Board getBoard(int boardId) {
        return boardMapper.getBoard(boardId);
    }

    public void uploadBoard(Board board) {
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        boardMapper.deleteBoard(boardId);
    }

}
