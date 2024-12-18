package com.min.myapp.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.myapp.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements IUserDao {

  private final SqlSessionTemplate template;
  
  @Override
  public int insertUser(UserDto userDto) {
    return template.insert("mybatis.mappers.noticeMapper.insertUser", userDto);
  }

  @Override
  public UserDto selectUserByMap(Map<String, Object> map) {
    return template.selectOne("mybatis.mappers.noticeMapper.selectUserByMap", map);
  }
}
