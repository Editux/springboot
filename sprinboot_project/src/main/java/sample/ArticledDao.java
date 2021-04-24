package sample;

import java.util.List;

public interface ArticledDao {
    List<Articles> findAll();

    public void deleteArticles(Articles articles);
}
