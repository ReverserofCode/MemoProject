package com.example.memo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MemoBody extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public MemoBody(MemoDTO memoDTO) {
        this.username = memoDTO.getUsername();
        this.contents = memoDTO.getContents();
    }

    public void update(MemoDTO memoDTO){
        this.username = memoDTO.getUsername();
        this.contents = memoDTO.getContents();
    }
}
