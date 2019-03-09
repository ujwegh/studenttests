package ru.nik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.nik.config.SpringConfig;


@ComponentScan
@Configuration
public class Main {


    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        context.register(SpringConfig.class);
// context.register(DaoConfig.class);
//        context.register(ServiceConfig.class);
//        List<Question> questions = context.getBean(QuestionService.class).getAllQuestions();
    }
}
