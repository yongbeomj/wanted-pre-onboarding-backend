package com.wanted.preonboarding.controller;

import com.wanted.preonboarding.dto.JobOpeningDto;
import com.wanted.preonboarding.service.JobOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job-openings")
public class JobOpeningController {

    private final JobOpeningService jobOpeningService;

    // 채용공고 등록
    @PostMapping
    public Object savePost(@RequestBody JobOpeningDto jobOpeningDto) {
        return jobOpeningService.savePost(jobOpeningDto);
    }

    // 채용공고 수정
    @PostMapping(value="/{jobId}")
    public Object updatePost(@PathVariable Long jobId, @RequestBody JobOpeningDto jobOpeningDto) {
        return jobOpeningService.updatePost(jobId, jobOpeningDto);
    }

}
