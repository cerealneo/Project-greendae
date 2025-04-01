package kr.co.greenuniversity.service.file;

import kr.co.greenuniversity.dto.FileDTO;
import kr.co.greenuniversity.dto.community.CommunityDTO1;
import kr.co.greenuniversity.entity.File;
import kr.co.greenuniversity.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FileService {

    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public void save(FileDTO fileDTO) {
        File file = modelMapper.map(fileDTO, File.class);
        fileRepository.save(file);
    }

    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    public List<FileDTO> uploadFile(CommunityDTO1 communityDTO1) {

        java.io.File fileUploadDir = new java.io.File(uploadDir);

        if (!fileUploadDir.exists()) {
            fileUploadDir.mkdirs();
        }

        String fileUploadPath = fileUploadDir.getAbsolutePath();
        List<MultipartFile> multipartFiles = communityDTO1.getMultipartFiles();
        List<FileDTO> fileDTOList = new ArrayList<>();

        for(MultipartFile multipartFile : multipartFiles) {

            if(!multipartFile.isEmpty()) {

                String oName = multipartFile.getOriginalFilename();
                String ext = oName.substring(oName.lastIndexOf("."));
                String sName = UUID.randomUUID().toString() + ext;

                try {
                    multipartFile.transferTo(new java.io.File(fileUploadPath, sName));
                }catch(IOException e) {
                    log.error(e.getMessage());
                }

                FileDTO fileDTO = FileDTO.builder()
                        .oName(oName)
                        .sName(sName)
                        .build();

                fileDTOList.add(fileDTO);
            }
        }
        return fileDTOList;
    }

    public ResponseEntity downloadFile(int fno) {

        Optional<File> optFile = fileRepository.findById(fno);

        File file = null;

        if(optFile.isPresent()){
            file = optFile.get();

            int count = file.getDownload();
            file.setDownload(count + 1);
            fileRepository.save(file);

            try{
                Path path = Paths.get(uploadDir + java.io.File.separator + file.getSName());
                String contentType = Files.probeContentType(path);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentDisposition(
                        ContentDisposition.builder("attachment")
                                .filename(file.getOName(), StandardCharsets.UTF_8)
                                .build());


                headers.add(HttpHeaders.CONTENT_TYPE, contentType);

                Resource resource = new InputStreamResource(Files.newInputStream(path));

                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .body(resource);

            }catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }




}
