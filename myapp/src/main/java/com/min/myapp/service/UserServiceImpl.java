package com.min.myapp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.min.myapp.dao.IUserDao;
import com.min.myapp.dto.UserDto;
import com.min.myapp.util.SecureUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

  private final IUserDao userDao;
  private final SecureUtil secureUtil;
  
  @Override
  public String signup(UserDto userDto) {
    
    // 비밀번호 암호화
    userDto.setUserPw(secureUtil.getSHA256(userDto.getUserPw()));
    
    // 이름 XSS 공격 방지
    userDto.setUserName(secureUtil.getPreventXSS(userDto.getUserName()));
    
    return userDao.insertUser(userDto) == 1 ? "회원 가입 성공" : "회원 가입 실패";
    
  }

  @Override
  public boolean login(HttpServletRequest request) {
    
    // userEmail과 userPw
    String userEmail = request.getParameter("userEmail");
    String userPw = secureUtil.getSHA256(request.getParameter("userPw"));
    
    // 접속 IP, 접속 브라우저 등 정보가 필요하면 request를 활용하세요.
    // String ip = request.getRemoteAddr();
    // String userAgent = request.getHeader("User-Agent");
    
    // DB로 보낼 Map을 만든 뒤 ,회원 존재 여부 확인
    UserDto userDto = userDao.selectUserByMap(Map.of("userEmail", userEmail, "userPw", userPw));
    
    // 회원 존재 여부 확인
    boolean exists = userDto != null;
    
    // 회원이 존재하면 세션에 회원 정보를 저장하기
    if(exists) {
      HttpSession session = request.getSession();
      session.setMaxInactiveInterval(60*60);    // 1시간 동안 세션 정보가 유지됩니다.
      session.setAttribute("loginUser", userDto);   // 세션에 loginUser 값이 있으면 로그인 상태입니다.
      // 여기서 추가로 접속 기록도 DB에 남겨야 합니다.
    }
    
    return exists;
    
  }
  
  @Override
  public void logout(HttpSession session) {
    session.invalidate();   // 세션 초기화 작업    
  }
  
}
