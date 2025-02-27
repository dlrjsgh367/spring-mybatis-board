package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public List<Board> getBoardList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return boardService.getBoardList(page, size);
    }

    @GetMapping("/detail")
    public Board getBoardDetail(@RequestParam int id) {
        return boardService.getBoardDetail(id);
    }

    @PostMapping("/create")
    public void createBoard(@RequestBody Board board) {
        boardService.createBoard(board);
    }

    @PostMapping("/update")
    public void updateBoard(@RequestBody Board board) {
        boardService.updateBoard(board);
    }

    @DeleteMapping("/delete")
    public void deleteBoard(@RequestParam int id) {
        boardService.deleteBoard(id);
    }
}
