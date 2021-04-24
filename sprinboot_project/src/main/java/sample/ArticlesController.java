package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/app")
public class ArticlesController {


        @Resource
       ArticlesServices articlesServices;
    @GetMapping("/articles")
    public List<Articles> getAll()throws Exception {

            return articlesServices.findAll();

    }



    }

