package sample;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticlesRowMapper implements RowMapper<Articles> {
    @Override
    public Articles mapRow(ResultSet rs, int arg1) throws SQLException {
        Articles art= new Articles();
        art.setId(rs.getString("articleid"));
        art.setTitle(rs.getString("title"));
        art.setContent(rs.getString("content"));

        return art;
    }
}
