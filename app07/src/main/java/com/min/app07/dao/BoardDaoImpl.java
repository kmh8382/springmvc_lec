package com.min.app07.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.app07.dto.BoardDto;

import lombok.RequiredArgsConstructor;

// import lombok.NonNull;

@RequiredArgsConstructor    // @AllArgsConstructor + @NonNull
@Repository                 // DAO에서 사용하는 @Component입니다. Spring Container에 IBoardDao 타입의 bean이 생성됩니다.
public class BoardDaoImpl implements IBoardDao {

  private final SqlSessionTemplate template;
  
  /*
   ** ************************ **
   ** @RequiredArgsConstructor **
   ** ************************ **
  // @Autowired
  public BoardDaoImpl(@NonNull SqlSessionTemplate template) {    // 타입이 일치하는 bean을 찾아 연결된다.
    super();
    this.template = template;
  }
  */

  /*
   * 매퍼의 SQL 구문 호출하는 방식
   * 
   * selectList(SQL's id[, Parameter])
   *  selectOne(SQL's id[, Parameter])
   *     insert(SQL's id[, Parameter])
   *     update(SQL's id[, Parameter])
   *     delete(SQL's id[, Parameter])
   */
  
  @Override
  public List<BoardDto> selectBoardList(String sort) {
    List<BoardDto> boardList = template.selectList("mybatis.mappers.boardMapper.selectBoardList", sort);
    return boardList;
  }

  @Override
  public int selectBoardCount() {
    int boardCount = template.selectOne("mybatis.mappers.boardMapper.selectBoardCount");
    return boardCount;
  }

  @Override
  public BoardDto selectBoardById(int boardId) {
    BoardDto boardDto = template.selectOne("mybatis.mappers.boardMapper.selectBoardById", boardId);
    return boardDto;
  }

  @Override
  public List<BoardDto> selectBoardSearchList(Map<String, Object> map) {
    List<BoardDto> searchList = template.selectList("mybatis.mappers.boardMapper.selectBoardSearchList", map);
    return searchList;
  }

  @Override
  public List<BoardDto> selectBoardPeriodList(Map<String, Object> map) {
    List<BoardDto> periodList = template.selectList("mybatis.mappers.boardMapper.selectBoardPeriodList", map);
    return periodList;
  }
  
  @Override
  public List<BoardDto> selectBoardIntegratedSearch(Map<String, Object> map) {
    List<BoardDto> list = template.selectList("mybatis.mappers.boardMapper.selectBoardIntegratedSearch", map);
    return list;
  }
  
  @Override
  public int selectBoardIntegratedSearchCount(Map<String, Object> map) {
    int boardCount = template.selectOne("mybatis.mappers.boardMapper.selectBoardIntegratedSearchCount", map);
    return boardCount;
  }
  
  @Override
  public int insertBoard(BoardDto boardDto) {
    int result = template.insert("mybatis.mappers.boardMapper.insertBoard", boardDto);
    return result;
  }

  @Override
  public int updateBoard(BoardDto boardDto) {
    int result = template.update("mybatis.mappers.boardMapper.updateBoard", boardDto);
    return result;
  }

  @Override
  public int deleteBoard(int boardId) {
    int result = template.delete("mybatis.mappers.boardMapper.deleteBoard", boardId);
    return result;
  }

  @Override
  public int deleteSelectedBoard(String[] numbers) {
    int result = template.delete("mybatis.mappers.boardMapper.deleteSelectedBoard", numbers);
    return result;
  }
}
