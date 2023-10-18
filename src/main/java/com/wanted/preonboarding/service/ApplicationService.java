package com.wanted.preonboarding.service;

import com.wanted.preonboarding.domain.Application;
import com.wanted.preonboarding.domain.JobOpening;
import com.wanted.preonboarding.domain.User;
import com.wanted.preonboarding.dto.ApplicationDto;
import com.wanted.preonboarding.repository.ApplicationRepository;
import com.wanted.preonboarding.repository.JobOpeningRepository;
import com.wanted.preonboarding.repository.UserRepository;
import com.wanted.preonboarding.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final UserRepository userRepository;

    // 채용공고 지원
    public Object saveApplication(ApplicationDto applicationDto) {
        try {
            Long jobId = applicationDto.getJobId();
            Long userId = applicationDto.getUserId();

            // validation
            applicationRepository.findByUserId(jobId, userId);

            JobOpening jobOpening = jobOpeningRepository.getReferenceById(jobId);
            User user = userRepository.getReferenceById(userId);
            Application application = Application.builder()
                    .user(user)
                    .jobOpening(jobOpening)
                    .build();
            applicationRepository.save(application);

            ApplicationDto result =  ApplicationDto.toDto(application);

            return ResponseUtil.success(result);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
    }


}
