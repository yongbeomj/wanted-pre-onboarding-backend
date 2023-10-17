package com.wanted.preonboarding.controller;

import com.wanted.preonboarding.domain.JobOpening;
import com.wanted.preonboarding.dto.JobOpeningDto;
import com.wanted.preonboarding.service.JobOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    // 채용공고 삭제
    @DeleteMapping("/{jobId}")
    public Object deletePost(@PathVariable Long jobId, @RequestBody JobOpeningDto jobOpeningDto) {
        return jobOpeningService.deletePost(jobId);
    }

    // 채용공고 조회
    @GetMapping
    public Page<JobOpening> getPost(@PageableDefault Pageable pageable) {
        return jobOpeningService.getPost(pageable);
    }

    // 채용공고 상세 조회
    @GetMapping("/{jobId}")
    public Object getDetailPost(@PathVariable Long jobId) {
        return jobOpeningService.getDetailPost(jobId);
    }
}
