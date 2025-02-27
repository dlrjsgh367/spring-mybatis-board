package com.example.board.service;

import com.example.board.mapper.BoardMapper;
import com.example.board.model.Board;

import java.util.List;

@Service
public class BoardService {
    @AutoWired
    private BoardMapper boardMapper;

    public List<Board> getBoardList(int page, int size) {
        int offset = (page - 1) * size;
        return boardMapper.getBoardList(offset, size);
    }

    public Board getBoardDetail(int id) {
        return boardMapper.getBoardDetail(id);
    }

    public void createBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }

    public List<Board> searchBoard(String keyword) {
        return boardMapper.searchBoard(keyword);
    }
}