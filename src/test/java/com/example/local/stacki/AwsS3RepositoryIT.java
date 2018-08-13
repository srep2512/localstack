package com.example.local.stacki;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

import cloud.localstack.DockerTestUtils;
import cloud.localstack.docker.LocalstackDockerTestRunner;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;


@LocalstackDockerProperties( services = { "s3" })
@RunWith(LocalstackDockerTestRunner.class)
public class AwsS3RepositoryIT {

	static AmazonS3 clientS3;
	
	@BeforeClass
	public static void init() {
		clientS3 = DockerTestUtils.getClientS3();	
		clientS3.createBucket("mybucket");
	}
	
	@Test
	public void testS3Access() {
		List<Bucket> buckets = clientS3.listBuckets();
		System.out.println("Fertig");
	}
}
