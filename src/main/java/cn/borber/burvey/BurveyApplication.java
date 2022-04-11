package cn.borber.burvey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BORBER
 */
@SpringBootApplication
@MapperScan("cn.borber.burvey.mapper")
public class BurveyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BurveyApplication.class, args);
    }
}
