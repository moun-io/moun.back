package io.moun.api.common.service;

import io.moun.api.common.domain.MounFile;
import io.moun.api.common.domain.MounFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MounFileService {
    
    private final MounFileRepository mounFileRepository;

    public MounFile uploadFileToDB(MultipartFile file) {

        try {
            String fileName = file.getOriginalFilename();
            MounFile build = MounFile.builder().fileName(fileName).build();

            return mounFileRepository.save(build);
        } catch (Exception e) {
            throw new RuntimeException("No file uploaded");
        }
    }
    
}
