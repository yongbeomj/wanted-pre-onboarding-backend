package com.wanted.preonboarding.controller;

import com.wanted.preonboarding.dto.JobOpeningDto;
import com.wanted.preonboarding.service.JobOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job-openings")
public class JobOpeningController {

    private final JobOpeningService jobOpeningService;

    // 채용공고 등록
    @PostMapping
    public ResponseEntity<?> registPost(@RequestBody JobOpeningDto jobOpeningDto) {
        boolean result = jobOpeningService.savePost(jobOpeningDto);

        String code = "";
        String status = "";
        String message = "";

        if (result) {
            code = "0";
            status = "success";
        } else {
            code = "999";
            status = "error";
            message = "error message";
        }

        Map<String, String> responseObj = new HashMap<>();
        responseObj.put("code", code);
        responseObj.put("status", status);
        responseObj.put("message", message);

        return ResponseEntity.ok().body(responseObj);
    }

}
