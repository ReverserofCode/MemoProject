package com.example.memo.service;

import com.example.memo.domain.MemoBody;
import com.example.memo.domain.MemoDTO;
import com.example.memo.domain.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemoService {
    private MemoRepository memoRepository;
    @Transactional
    public Long update(Long id, MemoDTO memoDTO){
        MemoBody memoBody = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memoBody.update(memoDTO);
        return memoBody.getId();
    }
}
