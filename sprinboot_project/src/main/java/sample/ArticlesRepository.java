package sample;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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



