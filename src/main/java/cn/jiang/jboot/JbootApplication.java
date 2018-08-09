package cn.jiang.jboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author jiang
 */
@SpringBootApplication
//启用JPA审计
@EnableJpaAuditing
//启用缓存
@EnableCaching
//启用异步
@EnableAsync
public class JbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JbootApplication.class, args);
    }
}
