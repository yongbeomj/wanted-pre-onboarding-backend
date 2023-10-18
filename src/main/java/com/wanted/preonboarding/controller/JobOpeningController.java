package com.wanted.preonboarding.controller;

import com.wanted.preonboarding.dto.request.JobOpeningReqDto;
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
    public Object savePost(@RequestBody JobOpeningReqDto jobOpeningReqDto) {
        return jobOpeningService.savePost(jobOpeningReqDto);
    }

    // 채용공고 수정
    @PatchMapping(value="/{jobId}")
    public Object updatePost(@PathVariable Long jobId, @RequestBody JobOpeningReqDto jobOpeningReqDto) {
        return jobOpeningService.updatePost(jobId, jobOpeningReqDto);
    }

    // 채용공고 삭제
    @DeleteMapping("/{jobId}")
    public Object deletePost(@PathVariable Long jobId) {
        return jobOpeningService.deletePost(jobId);
    }

    // 채용공고 조회
    @GetMapping
    public Object getPost(@RequestParam(required = false) String search) {
        return jobOpeningService.getPost(search);
    }

    // 채용공고 상세 조회
    @GetMapping("/{jobId}")
    public Object getDetailPost(@PathVariable Long jobId) {
        return jobOpeningService.getDetailPost(jobId);
    }
}
