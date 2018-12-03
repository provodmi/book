package ru.provodmi.guest.book.repository;


import ru.provodmi.guest.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestBook {
    private static Connection con;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getAllPosts());
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "29912090");
        return con;
    }

    /*public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        if (con == null) {
            try {
//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "29912090");
                System.out.println("connection was established");

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("connection can not to establish");
                System.exit(1);
            }
        }
        return con;
    }*/

    public static List<Post> getAllPosts() throws SQLException, ClassNotFoundException {

        ArrayList<Post> posts = new ArrayList<>();
        try (Connection c = getConnection();
             ResultSet resultSet = c.createStatement().executeQuery("SELECT * FROM posts");) {


            while (resultSet.next()) {
                Post post = new Post((long)resultSet.getInt("id"),resultSet.getString("txt"));
                posts.add(post);
            }
        }
        return posts;
    }

    public static void addPost(Post p) throws ClassNotFoundException, SQLException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO posts(id,txt) VALUES  (?,?)");) {
            ps.setLong(1, p.getId());
            ps.setString(2, p.getTxt());
            ps.execute();
        }
    }


    public static void deletePost(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE from posts WHERE id = ?")) {
            ps.setLong(1,id);
            ps.execute();
        }
    }
}
