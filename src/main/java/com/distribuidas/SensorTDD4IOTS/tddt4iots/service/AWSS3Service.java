package com.distribuidas.SensorTDD4IOTS.tddt4iots.service;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {
   void uploadFile(MultipartFile file);
}
