package com.min.myapp.dao;

import java.util.Map;

import com.min.myapp.dto.UserDto;

public interface IUserDao {
  int insertUser(UserDto userDto);
  UserDto selectUserByMap(Map<String, Object> map);
  int updateUserInfo(UserDto userDto);
  int updateUserProfile(UserDto userDto);
  int deleteUser(int user_id);  
}
