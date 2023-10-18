package com.wanted.preonboarding.repository;

import com.wanted.preonboarding.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a WHERE a.jobOpening.jobId = :jobId AND a.user.userId = :userId")
    List<String> findByUserId(Long jobId, Long userId);

}
