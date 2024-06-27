package com.example.account.controller;

import com.example.account.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller{
    @GetMapping("/hello")
    public ResponseEntity<CustomApiResponse<?>> printSubmissionNotice() {
        CustomApiResponse<?> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "김혜진 hw6 과제 제출합니다.");
        return ResponseEntity.ok(res);
    }
}