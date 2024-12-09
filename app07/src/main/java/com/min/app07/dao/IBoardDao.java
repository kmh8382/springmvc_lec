package com.min.app07.dao;

import java.util.List;

import com.min.app07.dto.BoardDto;

public interface IBoardDao {
  List<BoardDto> selectBoardList();
  int selectBoardCount();
  BoardDto selectBoardById(int boardId);
  int insertBoard(BoardDto boardDto);
  int updateBoard(BoardDto boardDto);
  int deleteBoard(int boardId);
}
