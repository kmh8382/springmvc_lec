package com.min.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.min.myapp.dto.BlogDto;
import com.min.myapp.service.IBlogService;

@RequestMapping(value="/blog")
@Controller
public class BlogController {

  @Autowired
  private IBlogService blogService;
  
  
  @RequestMapping(value="/list.do")
  public String list(Model model) {
    
    Map<String, Object> map = blogService.getBlogList();
    model.addAttribute("bloglist", map.get("bloglist"));
    model.addAttribute("count", map.get("count"));
    
    return "blog/list";
  }
    
  @RequestMapping(value="/increseHit.do")
  public String increseHit(
      @RequestParam(value="blog_id") int blog_id) {
    blogService.increseBlogHit(blog_id);
    return "redirect:/blog/detail.do?blog_id=" + blog_id;    
  }

  @RequestMapping(value="/detail.do")
  public String detail(
      @RequestParam(value="blog_id") int blog_id,
      Model model) {
    BlogDto blogDto = blogService.getBlogById(blog_id);
    model.addAttribute("blog", blogDto);    
    return "blog/detail";
  }
  
  @RequestMapping(value="/modify.do", method=RequestMethod.POST)
  public String modify(BlogDto blogDto, 
      RedirectAttributes redirectAttributes) {
    
    return "redirect:/blog/list.do";
  }
  
  @RequestMapping(value="/remove.do", method=RequestMethod.POST)
  public String remove(@RequestParam(value="blog_id") int blog_id, 
      RedirectAttributes redirectAttributes) {
    
    return "redirect:/blog/list.do";
  }
}
