package cn.hjmao.rest.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"cn.hjmao.rest"})
@ComponentScan(basePackages = {"cn.hjmao.rest"})
@EnableJpaRepositories(basePackages = {"cn.hjmao.rest"})
@EntityScan(basePackages = {"cn.hjmao.rest"})
public class JwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(JwtApplication.class, args);
  }
}
