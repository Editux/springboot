package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleSericeImp implements ArticlesServices
{
    @Autowired
    ArticledDao articleDao;
    @Override
    public List<Articles> findAll() {
        return articleDao.findAll();
    }

    @Override
    public void deleteEmployee(Articles art) {
         articleDao.deleteArticles(art);
    }


}
