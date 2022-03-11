package com.devko.magnet.dto.image;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDto {
    MultipartFile file;
}
