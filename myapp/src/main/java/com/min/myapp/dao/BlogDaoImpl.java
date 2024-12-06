package com.min.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.myapp.dto.BlogDto;

@Repository
public class BlogDaoImpl implements IBlogDao {

  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;
  
  @Override
  public void connect() {
    conn = null;
    
    try {
      String driver   = "com.mysql.cj.jdbc.Driver";
      String url      = "jdbc:mysql://127.0.0.1:3306/db_myapp?serverTimezone=Asia/Seoul";
      String username = "greenit";
      String password = "greenit";
      
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }    
  }

  @Override
  public void close() {
    try {
      if(conn != null)  conn.close();
      if(ps != null)    ps.close();
      if(rs != null)    rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  @Override
  public List<BlogDto> selectBlogList() {
    List<BlogDto>blogs = new ArrayList<BlogDto>();
    connect();    
    
    try {
      String sql = "SELECT blog_id, title, contents, user_email, hit, modify_dt, create_dt FROM tbl_blog ORDER BY blog_id DESC";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while(rs.next()) {
        BlogDto blogDto = BlogDto.builder()
                                 .blog_id(rs.getInt("blog_id"))
                                 .title(rs.getNString("title"))
                                 .contents(rs.getString("contents"))
                                 .user_email(rs.getString("user_email"))
                                 .hit(rs.getInt("hit"))
                                 .modify_dt(rs.getDate("modify_dt"))
                                 .create_dt(rs.getDate("create_dt"))
                                 .build();
        blogs.add(blogDto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    close();
    return blogs;
  }

  @Override
  public int selectBlogCount() {
    int amount = 0;
    connect();    
    
    try {
      String sql = "SELECT COUNT(*) as amount FROM tbl_blog"; 
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery(); 
      if(rs.next()) {
        amount = rs.getInt("amount");
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
        
    close();
    return amount;
  }

  @Override
  public BlogDto selectBlogById(int blog_id) {
    BlogDto blogDto = null;
    connect();    
    
    try {
      String sql = "SELECT blog_id, title, contents, user_email, hit, modify_dt, create_dt FROM tbl_blog WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id);
      rs = ps.executeQuery();
      
      if(rs.next()) {
        blogDto = BlogDto.builder()
                         .blog_id(rs.getInt("blog_id"))
                         .title(rs.getNString("title"))
                         .contents(rs.getString("contents"))
                         .user_email(rs.getString("user_email"))
                         .hit(rs.getInt("hit"))
                         .modify_dt(rs.getDate("modify_dt"))
                         .create_dt(rs.getDate("create_dt"))
                         .build();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    close();
    return blogDto;
  }

  @Override
  public int insertBlog(BlogDto blogDto) {
    int result = 0;
    connect();    
    
    try {
      String sql = "INSERT INTO tbl_blog VALUES (NULL, ?, ?, ?, 0, NULL, NOW())";
      ps = conn.prepareStatement(sql);
      ps.setString(1, blogDto.getTitle());
      ps.setString(2, blogDto.getContents());
      ps.setString(3, blogDto.getUser_email());
      result = ps.executeUpdate();      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    close();
    return result;
  }

  @Override
  public int updateBlog(BlogDto blogDto) {
    int result = 0;
    connect();    
    
    try {
      String sql = "UPDATE tbl_blog SET title = ?, contents = ?, modify_dt = NOW() WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, blogDto.getTitle());
      ps.setString(2, blogDto.getContents());
      ps.setInt(3, blogDto.getBlog_id()); 
      result = ps.executeUpdate(); 
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    close();
    return result;
  }

  @Override
  public int updateHit(int blog_id) {
    int result = 0;
    connect();    
    
    try {
      String sql = "UPDATE tbl_blog SET hit = hit + 1 WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id); 
      result = ps.executeUpdate(); 
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    close();
    return result;
  }

  @Override
  public int deleteBlog(int blog_id) {   
    int result = 0;
    connect();    
    
    try {
      String sql = "DELETE FROM tbl_blog WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id);
      result = ps.executeUpdate(); 
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    close();
    return result;
  }

}
