package com.example.memo.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface MemoRepository extends JpaRepository<MemoBody,Long> {

}
