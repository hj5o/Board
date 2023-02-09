package hj5o.board.practice2.controller;

import javax.servlet.http.HttpSession;

import hj5o.board.practice2.dto.ResponseDTO;
import hj5o.board.practice2.model.User;
import hj5o.board.practice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/login")
    public String login() {
        return "system/login";
    }

    @PostMapping("/auth/login")
    public @ResponseBody ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
        User findUser = userService.getUser(user.getUsername());

        // 검색 결과 유무와 사용자가 입력한 비밀번호가 유효한지 확인한다.
        if(findUser.getUsername() == null) {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "아이디가 존재하지 않아요.");
        } else {
            if(user.getPassword().equals(findUser.getPassword())) {
                // 로그인 성공 시 세션에 사용자 정보를 저장한다.
                session.setAttribute("principal", findUser);
                return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUsername() + "님 로그인 성공하셨습니다.");
            } else {
                return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "비밀번호 오류!");
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
