package io.github.nicolasjcaseres.movies;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.mongodb+srv://admin:3udcNswgqHPBtxSk@cluster0.puarzyv.mongodb.net/movie-api-db?retryWrites=true&w=majority}")
    private String uri;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://admin:3udcNswgqHPBtxSk@cluster0.puarzyv.mongodb.net/movie-api-db?retryWrites=true&w=majority");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "movie-api-db");
    }
}
