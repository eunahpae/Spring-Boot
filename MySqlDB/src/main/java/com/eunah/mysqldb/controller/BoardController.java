package com.eunah.mysqldb.controller;

import com.eunah.mysqldb.domain.Board;
import com.eunah.mysqldb.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/hello")
    public String hello() {
        return "/boards/hello";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.boardList());
        return "/boards/hello";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("list", service.boardList());
        return "/boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, int boardId) {
        model.addAttribute("view", service.getBoard(boardId));
        return "/boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm() {
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board) {
        service.uploadBoard(board);
        return "redirect:/board/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board) {
        service.updateBoard(board);
        return "redirect:/board/main";
    }

    @DeleteMapping("/delete")
    public String deleteBoard(Long boardId) {
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

}
