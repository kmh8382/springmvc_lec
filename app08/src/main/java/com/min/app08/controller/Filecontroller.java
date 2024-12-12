package com.min.app08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.min.app08.service.IFileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Filecontroller {

  private final IFileService fileService;
  
  @RequestMapping(value="/single/list.do")
  public String list(Model model) {
    model.addAttribute("fileList", fileService.getFileList());    
    return "list";
  }
  
  @RequestMapping(value="/single/upload.do")
  public String upload(MultipartHttpServletRequest multipartRequest, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("msg", fileService.uploadFile(multipartRequest));
    return "redirect:/single/list.do";
  }
  
}
