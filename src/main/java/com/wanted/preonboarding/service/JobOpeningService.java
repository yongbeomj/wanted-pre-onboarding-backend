package com.wanted.preonboarding.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.domain.Company;
import com.wanted.preonboarding.domain.JobOpening;
import com.wanted.preonboarding.dto.JobOpeningDto;
import com.wanted.preonboarding.repository.CompanyRepository;
import com.wanted.preonboarding.repository.JobOpeningRepository;
import com.wanted.preonboarding.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobOpeningService {

    private final JobOpeningRepository jobOpeningRepository;
    private final CompanyRepository companyRepository;

    // 채용공고 등록
    @Transactional
    public Object savePost(JobOpeningDto jobOpeningDto) {
        try {
            Company company = companyRepository.getReferenceById(jobOpeningDto.getCompanyId());
            JobOpening jobOpening = JobOpening.builder()
                    .company(company)
                    .position(jobOpeningDto.getPosition())
                    .reward(jobOpeningDto.getReward())
                    .content(jobOpeningDto.getContent())
                    .skill(jobOpeningDto.getSkill())
                    .build();
            jobOpeningRepository.save(jobOpening);

            return ResponseUtil.success(jobOpening);
        } catch (Exception e) {
            return ResponseUtil.error(e, HttpStatus.BAD_REQUEST);
        }
    }

    // 채용공고 수정
    @Transactional
    public Object updatePost(Long jobId, JobOpeningDto jobOpeningDto) {
        try {
            JobOpening jobOpening = jobOpeningRepository.getReferenceById(jobId);
            jobOpening.updateJobOpening(jobOpeningDto);
            jobOpeningRepository.save(jobOpening);

            return ResponseUtil.success(jobOpening);
        } catch (Exception e) {
            return ResponseUtil.error(e, HttpStatus.BAD_REQUEST);
        }
    }

    // 채용공고 삭제
    public Object deletePost(Long jobId) {
        try {
            jobOpeningRepository.deleteById(jobId);
            return ResponseUtil.success(jobId);
        } catch (Exception e){
            return ResponseUtil.error(e, HttpStatus.BAD_REQUEST);
        }
    }

    // 채용공고 조회
    public Page<JobOpening> getPost(Pageable pageable) {
        return jobOpeningRepository.findAll(pageable);
    }

}
