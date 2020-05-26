package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@SpringBootApplication
public class Java2S3Application {

	public static void main(String[] args) {
		SpringApplication.run(Java2S3Application.class, args);
		S3FileUpload s = new S3FileUpload();
		s.s3FileUpload();
	}
}
