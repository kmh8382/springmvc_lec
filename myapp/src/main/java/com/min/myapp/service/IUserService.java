package com.min.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.min.myapp.dto.UserDto;

public interface IUserService {
  String signup(UserDto userDto);
  boolean login(HttpServletRequest request);
  void logout(HttpSession session);
}
