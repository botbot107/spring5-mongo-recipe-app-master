package guru.springframework.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

public class DataSourceConfig {

	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
	    EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	    mongo.setBindIp("localhost");
	    MongoClient mongoClient = mongo.getObject();
	    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "test_or_whatever_you_want_to_call_this_db");
	    return mongoTemplate;
	}
}
