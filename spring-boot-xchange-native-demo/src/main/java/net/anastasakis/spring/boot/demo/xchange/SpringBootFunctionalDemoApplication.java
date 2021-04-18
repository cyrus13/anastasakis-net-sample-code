package net.anastasakis.spring.boot.demo.xchange;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.GenericApplicationContext;

@Profile("lambda")
@SpringBootApplication
public class SpringBootFunctionalDemoApplication implements ApplicationContextInitializer<GenericApplicationContext> {
    public static void main(String[] args) {
        FunctionalSpringApplication.run(SpringBootFunctionalDemoApplication.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        context.registerBean("foobar", FunctionRegistration.class,
                () -> new FunctionRegistration<>(new Foobar()).type(FunctionType.from(String.class).to(String.class)));
    }
}
