//package io.fourpet;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSCredentialsProvider;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
//import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableDynamoDBRepositories
//public class DynamoDBConfig {
//
//    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
//        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
//    }
//
//    @Bean
//    public static AWSCredentials amazonAWSCredentials() {
//        String userKey = System.getenv("AWS_USER_KEY");
//		String secretKey = System.getenv("AWS_SECRET_KEY");
//        return new BasicAWSCredentials(userKey, secretKey);
//    }
//
//    @Bean
//    public DynamoDBMapperConfig dynamoDBMapperConfig() {
//        return DynamoDBMapperConfig.DEFAULT;
//    }
//
//    @Bean
//    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
//        return new DynamoDBMapper(amazonDynamoDB, config);
//    }
//
//    @Bean
//    public AmazonDynamoDB amazonDynamoDB() {
//        return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
//                .withRegion(Regions.US_EAST_1).build();
//    }
//}
