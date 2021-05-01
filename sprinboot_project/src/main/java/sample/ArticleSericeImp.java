package sample;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ArticleSericeImp implements ArticlesServices
{

@Resource
    ArticledDao articleDao;
    @Override
    public List<Articles> findAll() {
        return articleDao.findAll();
    }

    @Override
    public void insertArticle(Articles art) {
        articleDao.insertArticle(art);
    }

    @Override
    public void updateArticle(Articles art) {
    articleDao.updateArticle(art);
    }


    @Override
    public void executeupdateArticle(Articles art) {
        articleDao.executeUpdateArticle(art);
    }

    @Override
    public void deleteArticle(Articles art) {
         articleDao.deleteArticles(art);
    }


}
