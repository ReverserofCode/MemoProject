package com.example.memo.controller;


import com.example.memo.domain.MemoBody;
import com.example.memo.domain.MemoDTO;
import com.example.memo.domain.MemoRepository;
import com.example.memo.service.MemoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityListeners;
import java.util.List;

@RestController
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public MemoBody insertDbMemo(@RequestBody MemoDTO memoDTO) {
        MemoBody memoBody = new MemoBody(memoDTO);
        return memoRepository.save(memoBody);
    }

    @GetMapping("/api/memos")
    public List<MemoBody> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoDTO memoDTO) {
        memoService.update(id,memoDTO);
        return id;
    }
}
