package com.min.myapp.dao;

import java.util.Map;

import com.min.myapp.dto.UserDto;

public interface IUserDao {
  int insertUser(UserDto userDto);
  UserDto selectUserByMap(Map<String, Object> map);
}
