package hj5o.board.practice1.controller;

import hj5o.board.practice1.entity.Board;
import hj5o.board.practice1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/form")
    public String form() {
        return "board/form";
    }

    @PostMapping("/board/form/process")
    public String formProcess(Board board, Model model, MultipartFile file) throws Exception {
        boardService.trans(board, file);
        model.addAttribute("message", "글 작성 완료");
        model.addAttribute("url", "/board/list");
        return "board/message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "board/list";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "board/view";
    }


    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "board/update";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board, Model model, MultipartFile file) throws Exception {
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());
        boardService.trans(boardTemp, file);
        model.addAttribute("message", "글 수정 완료");
        model.addAttribute("url", "/board/list");
        return "board/message";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id, Model model) {
        boardService.boardDelete(id);
        model.addAttribute("message", "글 삭제 완료");
        model.addAttribute("url", "/board/list");
        return "board/message";
    }
}
