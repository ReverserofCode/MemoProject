package com.example.memo.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.List;


@EnableJpaRepositories
public interface MemoRepository extends JpaRepository<MemoBody,Long> {
    List<MemoBody> findAllByOrderByModifiedAtDesc();
    List<MemoBody> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
