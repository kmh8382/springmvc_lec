package com.min.app13.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.min.app13.dao.IBbsDao;
import com.min.app13.dto.BbsDto;
import com.min.app13.util.PageUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BbsServiceImpl implements IBbsService {

  private final IBbsDao bbsDao;
  private final PageUtil pageUtil;
  
  @Override
  public String registBbs(BbsDto bbsDto) {           
    return bbsDao.insertBbs(bbsDto) == 1 ? "작성 성공" : "작성 실패";  
  }
  
  @Override
  public Map<String, Object> getBbsList(HttpServletRequest request) {
    Optional<String> optPage = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(optPage.orElse("1"));
    
    Optional<String> optDisplay = Optional.ofNullable(request.getParameter("display"));
    int display = Integer.parseInt(optDisplay.orElse("2"));
    
    int count = bbsDao.selectBbsCount();
    
    pageUtil.setPaging(page, display, count);
    
    int offset = pageUtil.getOffset();
    
    List<BbsDto> bbsList = bbsDao.selectBbsList(Map.of("offset", offset, "display", display));
    
    String paging = pageUtil.getPaging(request.getContextPath() + "/bbs/list.do", "");
    
    return Map.of("offset", offset, "count", count, "bbsList", bbsList, "paging", paging);
  }
  
  
  
}
