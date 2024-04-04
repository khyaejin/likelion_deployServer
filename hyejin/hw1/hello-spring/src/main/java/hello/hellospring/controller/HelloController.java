package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.processing.Generated;

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
        return "hello-template"; //html을 조작해서(랜더링 된 html) 화면에 내는(고객에게 주는) 방식
    }

    @GetMapping("hello-string")
    @ResponseBody //html body에 return부 직접 들어감
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //hello spring 문자열만 띡 하고 화면에 내는 방식
    }

    /**
     @ResponseBody 를 사용
     - HTTP의 BODY에 문자 내용을 직접 반환
     - viewResolver 대신에 HttpMessageConverter가 동작
     - 기본 문자처리 : StringHttpMessageConverter가
     - 기본 객체처리 : MappingJackson2HttpMessageConverter
     - byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
     **/

    @GetMapping("hello-api")
    @ResponseBody //객체로 반환하면 Json으로 들어가도록 기본적으로 정해져 있음 (대부분 이걸로)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

// MVC: Model, View, Controller. 분리시킨 것
// View : 화면에 관련된 일
// Controller : 비지니스 로직, 서버 뒷단에 관련 것 처리 후
// Model : 모델에 담아 화면으로 넘겨주기