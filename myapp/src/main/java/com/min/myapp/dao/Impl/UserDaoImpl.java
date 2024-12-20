package com.min.myapp.dao.Impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.myapp.dao.IUserDao;
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

  @Override
  public int updateUserInfo(UserDto userDto) {
    return template.update("mybatis.mappers.noticeMapper.updateUserInfo", userDto);
  }
  
  @Override
  public int updateUserProfile(UserDto userDto) {
    return template.update("mybatis.mappers.noticeMapper.updateUserProfile", userDto);
  }
  
  @Override
  public int deleteUser(int user_id) {
    return template.delete("mybatis.mappers.noticeMapper.deleteUser", user_id);  
  }
  
}
