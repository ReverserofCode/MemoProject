package com.example.memo.controller;


import com.example.memo.domain.MemoBody;
import com.example.memo.domain.MemoDTO;
import com.example.memo.domain.MemoRepository;
import com.example.memo.service.MemoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityListeners;

@RestController
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public MemoBody insertDbMemo(@RequestBody MemoDTO memoDTO){
        MemoBody  memoBody = new MemoBody(memoDTO);

        return  memoRepository.save(memoBody);
    }

}
