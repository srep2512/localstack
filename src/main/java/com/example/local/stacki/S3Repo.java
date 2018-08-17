package com.example.local.stacki;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListBucketsRequest;

public class S3Repo {
	
	AmazonS3 client;
	
	public S3Repo(AmazonS3 client,String bucket) {
		this.client = client;
		client.createBucket(bucket);
	}
	
	public void listBuckets() {
		ListBucketsRequest req = new ListBucketsRequest();		
		client.listBuckets(req);
	}

}
