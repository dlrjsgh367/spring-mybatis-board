package com.example.board.mapper;

import com.example.board.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardList(@Param("offset") int offset, @Param("size") int limit);

    Board getBoardDetail(@Param("id") int id);

    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(@Param("id") int id);

    List<Board> searchBoard(@Param("keyword") String keyword);
}
