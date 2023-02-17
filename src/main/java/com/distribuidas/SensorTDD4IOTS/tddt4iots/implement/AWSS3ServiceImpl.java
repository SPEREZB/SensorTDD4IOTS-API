package com.distribuidas.SensorTDD4IOTS.tddt4iots.implement;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.AWSS3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AWSS3ServiceImpl implements AWSS3Service {

     @Autowired
    private AmazonS3 amazonS3;

    private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3ServiceImpl.class);
     @Value("$aws.s3.bucket")
     private  String bucketName;

    @Override
    public  void uploadFile(MultipartFile file)
    {
          File mainFile= new File(file.getOriginalFilename());
           try(FileOutputStream stream =
                       new FileOutputStream(mainFile)){
               stream.write(file.getBytes());
             String newFileName= System.currentTimeMillis()+"_"+mainFile.getName();
               LOGGER.info("Subiendo archivo con el nombre... " + newFileName);
               PutObjectRequest request = new PutObjectRequest("sensorcardiaco", newFileName, mainFile);
               amazonS3.putObject(request);
           }catch (IOException ex)
           {
               LOGGER.error(ex.getMessage(), ex);
           }
    }
}