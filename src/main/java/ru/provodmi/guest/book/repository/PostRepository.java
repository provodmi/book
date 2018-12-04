package ru.provodmi.guest.book.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.provodmi.guest.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Post> getAllPosts(){
        return jdbcTemplate.query("select * from posts",new PostRowMapper());
    }

    public void add(String txt) {

        final String sql = "insert into posts(post) values(?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, txt);
                return ps;
            }
        });
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from posts where id=?",id);
    }
}

class PostRowMapper implements RowMapper<Post>
{
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong("id"));
        post.setTxt(rs.getString("txt"));
        return post;
    }
}
