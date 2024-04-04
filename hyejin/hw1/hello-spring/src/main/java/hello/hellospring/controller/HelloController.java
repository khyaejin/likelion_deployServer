package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")//url에 매칭 -> controller에 있는 것들이 실행됨
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";//resources:templates/hello.html을 열어라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

}

// MVC: Model, View, Controller. 분리시킨 것
// View : 화면에 관련된 일
// Controller : 비지니스 로직, 서버 뒷단에 관련 것 처리 후
// Model : 모델에 담아 화면으로 넘겨주기