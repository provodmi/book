package ru.provodmi.guest.book.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.provodmi.guest.book.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from books", new BookRowMapper());
    }

    public void add(Book book) {
        final String sql = "insert into books(author,title,year) values(?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, book.getAuthor());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getYear());
                return ps;
            }
        });
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from books where id=?", id);
    }


    public Book get(Long id) {
        return jdbcTemplate.queryForObject("SELECT * from BOOKS where id=" + id, new BookRowMapper());
    }

    class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book(rs.getLong("id"), rs.getString("author"),rs.getString("title"),rs.getString("year"));
            return book;
        }
    }
}