package postoffice.demo.config;


import org.springframework.context.annotation.Configuration;

@Configuration

public class ServiceConfiguration {
    public static String redisServer = "127.0.0.1";
    public static int port = 6379;
}

