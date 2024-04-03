package likelion12.likelion121.controller;

import likelion12.likelion121.service.MemberService;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
