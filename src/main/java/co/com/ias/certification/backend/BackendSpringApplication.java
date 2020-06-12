package co.com.ias.certification.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class BackendSpringApplication {

    public Boolean isEmptyList(Collection<?> collection) {
        Predicate<Collection<?>> collectionIsNotEmpty = col -> !col.isEmpty();
        return Optional.ofNullable(collection)
                .filter(collectionIsNotEmpty)
                .isPresent();
    }


    public static void main(String[] args) {
        SpringApplication.run(BackendSpringApplication.class, args);
    }

}
