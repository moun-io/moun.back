package io.moun.api.common.service;

import io.moun.api.common.domain.MounFile;
import io.moun.api.common.domain.MounFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MounFileService {
    
    private final MounFileRepository mounFileRepository;

    @Value("${spring.servlet.multipart.location}")
    public String LOCAL_UPLOAD_DIR;

    //upload file
    public MounFile uploadFileToLocalAndSave(MultipartFile file) {

        try {
            String fileName = generateUniqueFileName(file);
            
            String path = LOCAL_UPLOAD_DIR + "/" + fileName;
            file.transferTo(new File(path));
            
            MounFile uploadedFile = MounFile.builder().fileName(fileName).build();

            return mounFileRepository.save(uploadedFile);
            
        } catch (Exception e) {
            throw new RuntimeException("No file uploaded");
        }
    }

    private String generateUniqueFileName(MultipartFile file) {

        if (file.isEmpty()) {
            return null;
        }
        
        String originName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String fileExtension = originName.substring(originName.lastIndexOf("."));
        
        return "file_" + uuid + fileExtension;
    }
    
    
    
}
