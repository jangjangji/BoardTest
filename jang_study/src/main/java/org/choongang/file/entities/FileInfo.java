package org.choongang.file.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class FileInfo {
    @Id @GeneratedValue
    private Long seq;
    @Column(length = 45, nullable = false)
    private String gid = UUID.randomUUID().toString(); // 설정하지 않았을 경우 gid 랜덤하게 생성
    @Column(length = 45)
    private String location;

    @Column(length = 80, nullable = false)
    private String fileName;
    @Column(length = 80)
    private String contentType;

    @Column(length = 30)
    private String extension;

    private boolean done;
}
