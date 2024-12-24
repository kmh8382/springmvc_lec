package com.min.app13.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.app13.dto.BbsDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BbsDaoImpl implements IBbsDao {
  
  private final SqlSessionTemplate template;
  
  @Override
  public int insertBbs(BbsDto bbsDto) {   
    return template.insert("mybatis.mappers.bbsMapper.insertBbs", bbsDto);
  }
  
  @Override
  public List<BbsDto> selectBbsList(Map<String, Object> map) {
    return template.selectList("mybatis.mappers.bbsMapper.selectBbsList", map);
  }
  
  @Override
  public int selectBbsCount() {
    return template.selectOne("mybatis.mappers.bbsMapper.selectBbsCount");  
  }
  
  
}
