package sample;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public  class ArticlesRepository implements ArticledDao{



  public ArticlesRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
NamedParameterJdbcTemplate template;

    @Override
    public List<Articles> findAll() {
        return template.query("select * from article", new ArticlesRowMapper());
    }

    @Override
    public void insertArticle(Articles art) {
        final String sql = "insert into article(articleid, title , content) values(:articleid,:title,:content)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("articleid", art.getId())
                .addValue("title",art.getTitle())
                .addValue("content",art.getContent());

        template.update(sql,param, holder);
    }

    @Override
    public void updateArticle(Articles art) {
        final String sql = "update article set title=:title, content=:content where articleid=:articleid";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("articleid", art.getId())
                .addValue("title", art.getTitle())
                .addValue("content", art.getContent());

        template.update(sql,param, holder);

    }

    @Override
    public void executeUpdateArticle(Articles art) {
        final String sql = "update article set title=:title, content=:content  where articleid=:articleid";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("articleid", art.getId());
        map.put("title", art.getTitle());
        map.put("content", art.getContent());


        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }


    @Override
    public void deleteArticles(Articles articles) {
        final String sql = "delete from article where articleid=:articleid";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("articleid", articles.getId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }



    }



