package com.wanted.preonboarding.repository;

import com.wanted.preonboarding.domain.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {

    Optional<JobOpening> findByJobId(Long jobId);

}
