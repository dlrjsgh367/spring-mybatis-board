package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String getBoardList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        List<Board> boardList = boardService.getBoardList(page, size);
        model.addAttribute("boardList", boardList);
        return "board/list"; // "WEB-INF/views/board/list.jsp"
    }

    @GetMapping("/detail")
    public String getBoardDetail(@RequestParam int id, Model model) {
        Board board = boardService.getBoardDetail(id);
        model.addAttribute("board", board);
        return "board/detail"; // "WEB-INF/views/board/detail.jsp"
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "board/create"; // "WEB-INF/views/board/create.jsp"
    }

    @PostMapping("/create")
    public String createBoard(@ModelAttribute Board board) {
        boardService.createBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Board board = boardService.getBoardDetail(id);
        model.addAttribute("board", board);
        return "board/edit"; // "WEB-INF/views/board/edit.jsp"
    }

    @PostMapping("/update")
    public String updateBoard(@ModelAttribute Board board) {
        boardService.updateBoard(board);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String deleteBoard(@RequestParam int id) {
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }

    @GetMapping("/search")
    public String searchBoard(@RequestParam("keyword") String keyword, Model model) {
        List<Board> searchResults = boardService.searchBoard(keyword);
        model.addAttribute("boardList", searchResults);
        return "board/list"; // 검색 결과도 동일한 리스트 페이지 사용
    }
}
