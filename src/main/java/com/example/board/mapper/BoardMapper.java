package com.example.board.mapper;

import com.example.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardList(int offset, int limit);

    Board getBoardDetail(int id);

    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(int id);

    List<Board> searchBoard(String keyword);
}
