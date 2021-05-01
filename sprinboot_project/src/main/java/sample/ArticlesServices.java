package sample;

import java.util.List;

public interface ArticlesServices {
    List<Articles> findAll();
    void insertArticle(Articles art);

    void updateArticle(Articles art);
    void executeupdateArticle(Articles art);

    void deleteArticle(Articles art);

}
