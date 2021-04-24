package sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
@RestController
public class ArticlesController {


        @Autowired
        ArticleServices articlesService;

        @GetMapping("/getPatientDetails")
        public Articles getArticlesDetails(@RequestParam String title ) throws InterruptedException, ExecutionException{
            return articlesService.getArticlesDetails(title);
        }



        @DeleteMapping("/deletePatient")
        public String deleteArticle(@RequestParam String title){
            return articlesService.deleteArticle(title);
        }
    }

