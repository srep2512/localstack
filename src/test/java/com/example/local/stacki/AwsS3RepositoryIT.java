package com.example.local.stacki;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

import cloud.localstack.DockerTestUtils;
import cloud.localstack.docker.LocalstackDockerTestRunner;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;


@LocalstackDockerProperties(randomizePorts = true, services = { "s3" })
@RunWith(LocalstackDockerTestRunner.class)
public class AwsS3RepositoryIT {

	@Test
	public void testS3Access() {
		AmazonS3 aws = DockerTestUtils.getClientS3();		
		aws.createBucket("mybucket");
		List<Bucket> buckets = aws.listBuckets();
	}
}
