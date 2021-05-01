package sample;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/app")
public class ArticlesController {


@Resource
ArticlesServices articlesServices;
    @GetMapping(value="/articles")
    public List<Articles> getAll()throws Exception {

            return articlesServices.findAll();

    }
    @PostMapping(value = "/createArt")
    public void createArticle(@RequestBody Articles art) {
        articlesServices.insertArticle(art);

    }
    @PutMapping(value = "/updateArt")
    public void updateArticle(@RequestBody Articles art) {
        articlesServices.updateArticle(art);

    }
    @PutMapping(value = "/executeUpdateArt")
    public void executeUpdateEmployee(@RequestBody Articles art) {
        articlesServices.executeupdateArticle(art);

    }
    @DeleteMapping(value = "/deleteArtbyId")
    public void deleteEmployee(@RequestBody Articles art) {
        articlesServices.deleteArticle(art);

    }


    }

