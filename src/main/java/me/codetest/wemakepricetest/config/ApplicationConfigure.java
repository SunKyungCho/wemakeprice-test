package me.codetest.wemakepricetest.config;


import me.codetest.wemakepricetest.application.UrlTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfigure {


    @Bean
    public UrlTemplate urlTemplate() {
        return new UrlTemplate(new RestTemplate());
    }

}
