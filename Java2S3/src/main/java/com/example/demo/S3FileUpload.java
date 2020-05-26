package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3FileUpload {
	
	public void s3FileUpload() {
		
		AWSCredentials credentials = new BasicAWSCredentials(Constants.acces_id, Constants.acces_key);
		
		AmazonS3 s3client = new AmazonS3Client(credentials);
		
		String bucketName = "madhavfirsbucket";
		String folderName = "madhavfolder";
		s3client.createBucket(bucketName);
		
		for (Bucket bucket : s3client.listBuckets()) {
			System.out.println(" Bucket Name: " + bucket.getName());
		}
		
		createFolder(bucketName, folderName, s3client);
		
		String fileName = folderName + "/" + "madhav.txt";
		s3client.putObject(new PutObjectRequest(bucketName, fileName, 
				new File("D:\\okays.txt")));

	}
	
	
	
	

	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
					folderName + "/", emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}
	
	


}
