package com.min.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.min.myapp.dto.UserDto;

public interface IUserService {
  String signup(UserDto userDto);
  boolean login(HttpServletRequest request);
  void logout(HttpSession session);
  UserDto mypage(int userId);
  String modifyInfo(UserDto userDto);
  String modifyProfile(MultipartFile profile, int userId);
  String removeUser(int user_id, String profileImg, HttpSession session);
}
