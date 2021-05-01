package sample;


import java.util.List;

public interface ArticledDao {
    List<Articles> findAll();
    void insertArticle(Articles art);

    void updateArticle(Articles art);

    void executeUpdateArticle(Articles art);

    public void deleteArticles(Articles articles);
}
