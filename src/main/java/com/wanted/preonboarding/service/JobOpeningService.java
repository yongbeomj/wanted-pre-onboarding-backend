package com.wanted.preonboarding.service;

import com.wanted.preonboarding.domain.Company;
import com.wanted.preonboarding.domain.JobOpening;
import com.wanted.preonboarding.dto.JobOpeningDto;
import com.wanted.preonboarding.repository.CompanyRepository;
import com.wanted.preonboarding.repository.JobOpeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class JobOpeningService {

    private final JobOpeningRepository jobOpeningRepository;
    private final CompanyRepository companyRepository;

    // 채용공고 등록
    @Transactional
    public boolean savePost(JobOpeningDto jobOpeningDto) {
        Company company = companyRepository.getReferenceById(jobOpeningDto.getCompanyId());
        JobOpening jobOpening = JobOpening.builder()
                .company(company)
                .position(jobOpeningDto.getPosition())
                .reward(jobOpeningDto.getReward())
                .content(jobOpeningDto.getContent())
                .skill(jobOpeningDto.getSkill())
                .build();
        jobOpeningRepository.save(jobOpening);
        return true;
    }

}
