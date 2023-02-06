package hj5o.board.practice2.controller;

import hj5o.board.practice2.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {
    @GetMapping("/jblog")
    public User httpGet() {
        User findUser = User.builder().id(1).username("hj5o").password("1234").email("hj5o@gmail.com").build();
        return findUser;
    }

    @PostMapping("/jblog")
    public String httpPost(@RequestBody User user) {
        return "POST 요청 입력 값 : " + user.toString();
    }

    @PutMapping("/jblog")
    public String httpPut(@RequestBody User user) {
        return "PUT 요청 입력 값 : " + user.toString();
    }

    @DeleteMapping("/jblog")
    public String httpDelete(@RequestParam int id) {
        return "DELETE 요청 값 : " + id;
    }
}
