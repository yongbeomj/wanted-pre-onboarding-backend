package com.wanted.preonboarding.repository;

import com.wanted.preonboarding.domain.JobOpening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {

    Optional<JobOpening> findByJobId(Long jobId);

    @Query("SELECT j FROM JobOpening j JOIN j.company c WHERE j.position LIKE %:search% OR j.skill LIKE %:search% OR c.companyName LIKE %:search%")
    Page<JobOpening> searchByKeyword(@Param("search") String search, Pageable pageable);

}
