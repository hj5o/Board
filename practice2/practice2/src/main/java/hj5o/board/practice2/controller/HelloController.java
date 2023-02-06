package hj5o.board.practice2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/html")
    public String html() {
        System.out.println("html 파일 요청");
        return "redirect:hello.html";
    }

    @GetMapping("/img")
    public String img() {
        System.out.println("img 파일 요청");
        return "redirect:img/85.png";
    }

    @GetMapping("/jsp")
    public String jsp(Model model) {
        System.out.println("jsp 파일 요청");
        model.addAttribute("username", "hj5o");
        return "hello";
    }
}
