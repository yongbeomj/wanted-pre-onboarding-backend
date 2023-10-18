package com.wanted.preonboarding.service;

import com.wanted.preonboarding.domain.Company;
import com.wanted.preonboarding.domain.JobOpening;
import com.wanted.preonboarding.dto.request.JobOpeningReqDto;
import com.wanted.preonboarding.dto.response.JobOpeningDtlResDto;
import com.wanted.preonboarding.dto.response.JobOpeningListResDto;
import com.wanted.preonboarding.dto.response.JobOpeningUpdateResDto;
import com.wanted.preonboarding.repository.CompanyRepository;
import com.wanted.preonboarding.repository.JobOpeningRepository;
import com.wanted.preonboarding.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOpeningService {

    private final JobOpeningRepository jobOpeningRepository;
    private final CompanyRepository companyRepository;

    // 채용공고 등록
    @Transactional
    public Object savePost(JobOpeningReqDto jobOpeningReqDto) {
        try {
            Company company = companyRepository.getReferenceById(jobOpeningReqDto.getCompanyId());
            JobOpening jobOpening = JobOpening.builder()
                    .company(company)
                    .position(jobOpeningReqDto.getPosition())
                    .reward(jobOpeningReqDto.getReward())
                    .content(jobOpeningReqDto.getContent())
                    .skill(jobOpeningReqDto.getSkill())
                    .build();
            jobOpeningRepository.save(jobOpening);

            return ResponseUtil.success();
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
    }

    // 채용공고 수정
    @Transactional
    public Object updatePost(Long jobId, JobOpeningReqDto jobOpeningReqDto) {
        try {
            JobOpening jobOpening = jobOpeningRepository.getReferenceById(jobId);
            jobOpening.updateJobOpening(jobOpeningReqDto);
            jobOpeningRepository.save(jobOpening);

            JobOpeningUpdateResDto jobOpeningUpdateResDto = JobOpeningUpdateResDto.toDto(jobOpening);

            return ResponseUtil.success(jobOpeningUpdateResDto);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
    }

    // 채용공고 삭제
    public Object deletePost(Long jobId) {
        try {
            jobOpeningRepository.deleteById(jobId);
            return ResponseUtil.success();
        } catch (Exception e){
            return ResponseUtil.error(e.getMessage());
        }
    }

    // 채용공고 조회
    public Object getPost(String search) {
        try {
            List<JobOpening> jobOpenings;
            if (search == null || search.isBlank()) {
                jobOpenings = jobOpeningRepository.findAll();
            } else {
                jobOpenings = jobOpeningRepository.searchByKeyword(search);
            }

            List<JobOpeningListResDto> jobOpeningList = new ArrayList<>();
            for (JobOpening jobOpening : jobOpenings) {
                JobOpeningListResDto jobOpeningListResDto = JobOpeningListResDto.toDto(jobOpening);
                jobOpeningList.add(jobOpeningListResDto);
            }

            return ResponseUtil.success(jobOpeningList);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }

    }

    // 채용공고 상세 조회
    public Object getDetailPost(Long jobId) {
        try {
            JobOpening jobOpening = jobOpeningRepository.getReferenceById(jobId);
            List<String> jobIds = jobOpeningRepository.findByOtherPosts(jobId, jobOpening.getCompany().getCompanyId());

            JobOpeningDtlResDto jobOpeningDtlResDto = JobOpeningDtlResDto.toDto(jobOpening, jobIds);

            return ResponseUtil.success(jobOpeningDtlResDto);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
    }

}
