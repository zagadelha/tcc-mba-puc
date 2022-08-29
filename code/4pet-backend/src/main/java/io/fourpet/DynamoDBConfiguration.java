package io.fourpet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildConnection());
	}

	private AmazonDynamoDB buildConnection() {

		String endPoint = "dynamodb.us-east-1.amazonaws.com";
		String region = "us-east-1";
		String userKey = System.getenv("AWS_USER_KEY");
		String secretKey = System.getenv("AWS_SECRET_KEY");

		return AmazonDynamoDBAsyncClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, region))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(userKey, secretKey))).build();

	}

}
