package com.min.app12.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.min.app12.dto.UserDto;
import com.min.app12.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

  private final IUserService userService;
  
  @RequestMapping(value="/user/signup.form")
  public String signupForm() {
    return "user/signup";
  }
  
  @RequestMapping(value="/user/signup.do", method=RequestMethod.POST)
  public String signup(UserDto userDto, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("msg", userService.signup(userDto));
    return "redirect:/";
  }
  
  @RequestMapping(value="/user/login.form")
  public String loginForm(@RequestParam(name="url", required=false, defaultValue="http://localhost:8080/app12/") String url,
                          Model model) {
    model.addAttribute("url", url);
    return "user/login";
  }
  
  @RequestMapping(value="/user/login.do", method=RequestMethod.POST)
  public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    boolean loginSuccess = userService.login(request);
    String url = request.getParameter("url");
    if(!loginSuccess) {
      redirectAttributes.addFlashAttribute("msg", "일치하는 회원 정보가 없습니다.");
      return "redirect:/user/login.form?url=" + url;
    }
    return "redirect:" + url;
  }
  
  @RequestMapping(value="/user/logout.do")
  public String logout(HttpSession session) {
    userService.logout(session);
    return "redirect:/";
  }
  
}
