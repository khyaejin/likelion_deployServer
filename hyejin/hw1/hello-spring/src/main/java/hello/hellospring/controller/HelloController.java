package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("hello")//url에 매칭 -> controller에 있는 것들이 실행됨
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";//resources:templates/hello.html을 열려라
    }
}