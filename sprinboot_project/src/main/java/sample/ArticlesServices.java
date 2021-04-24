package sample;

import org.springframework.context.annotation.ComponentScan;

import java.util.List;
@ComponentScan
public interface ArticlesServices {
    List<Articles> findAll();

    void deleteEmployee(Articles art);

}
