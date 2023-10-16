package com.wanted.preonboarding.controller;

import com.wanted.preonboarding.domain.JobOpening;
import com.wanted.preonboarding.dto.JobOpeningDto;
import com.wanted.preonboarding.dto.common.ResponseDto;
import com.wanted.preonboarding.service.JobOpeningService;
import com.wanted.preonboarding.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job-openings")
public class JobOpeningController {

    private final JobOpeningService jobOpeningService;

    // 채용공고 등록
    @PostMapping
    public Object test(@RequestBody JobOpeningDto jobOpeningDto) {
        try {
            jobOpeningService.savePost(jobOpeningDto);

            return ResponseUtil.success(jobOpeningDto);
        } catch (Exception e) {
            return ResponseUtil.error(e, HttpStatus.BAD_REQUEST);
        }
    }

}
