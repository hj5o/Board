package hj5o.board.practice2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HTTPController {

    // GET : SELECT
    @GetMapping("/blog")
    public @ResponseBody String httpGet() {
        return "GET 요청 처리";
    }

    // POST : INSERT
    @PostMapping("/blog")
    public @ResponseBody String httpPost() {
        return "POST 요청 처리";
    }

    // PUT : UPDATE
    @PutMapping("/blog")
    public @ResponseBody String httpPut() {
        return "PUT 요청 처리";
    }

    // DELETE : DELETE
    @DeleteMapping("/blog")
    public @ResponseBody String httpDelete() {
        return "DELETE 요청 처리";
    }

    @GetMapping("/jsp")
    public String jsp() {
        System.out.println("JSP 파일이 요청됨");
        return "hello";
    }

}
