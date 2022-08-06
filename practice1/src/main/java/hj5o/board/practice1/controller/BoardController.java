package hj5o.board.practice1.controller;

import hj5o.board.practice1.entity.Board;
import hj5o.board.practice1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/form")
    public String form() {
        return "board/Form";
    }

    @PostMapping("/board/form/process")
    public String formProcess(Board board) {

        boardService.trans(board);

        return "";
    }
}
