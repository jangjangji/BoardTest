package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.repositories.FileInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.choongang.file.entities.QFileInfo.fileInfo;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final FileInfoRepository fileInfoRepository;
    public void upload(MultipartFile[] files, String gid, String location){

        gid = StringUtils.hasText(gid) ? gid : UUID.randomUUID().toString();
        List<FileInfo> uploadedFiles = new ArrayList<>();

        //2. 파일을 서버로 이동

    }
}
