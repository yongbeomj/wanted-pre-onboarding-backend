package com.wanted.preonboarding.controller;

import com.wanted.preonboarding.dto.ApplicationDto;
import com.wanted.preonboarding.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job-openings")
public class AplicationContoller {

    private final ApplicationService applicationService;

    @PostMapping("/application")
    public Object saveApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.saveApplication(applicationDto);
    }

}
