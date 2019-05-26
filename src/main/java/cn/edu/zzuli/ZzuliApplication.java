package cn.edu.zzuli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZzuliApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZzuliApplication.class, args);
    }

}
