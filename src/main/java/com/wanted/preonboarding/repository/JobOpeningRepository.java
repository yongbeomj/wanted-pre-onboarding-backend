package com.wanted.preonboarding.repository;

import com.wanted.preonboarding.domain.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {
    @Query("SELECT j.jobId FROM JobOpening j JOIN j.company c WHERE j.jobId != :jobId AND c.companyId = :companyId")
    List<String> findByOtherPosts(Long jobId, Long companyId);

    @Query("SELECT j FROM JobOpening j JOIN j.company c WHERE j.position LIKE %:search% OR j.skill LIKE %:search% OR c.companyName LIKE %:search%")
    List<JobOpening> searchByKeyword(@Param("search") String search);

}
