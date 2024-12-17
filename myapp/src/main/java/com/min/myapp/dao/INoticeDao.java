package com.min.myapp.dao;

import java.util.List;

import com.min.myapp.dto.AttachDto;
import com.min.myapp.dto.NoticeDto;

public interface INoticeDao {
  List<NoticeDto> selectNoticeList();
  NoticeDto selectNoticeById(int noticeId);
  List<AttachDto> selectAttachListByNoticeId(int noticeId);
  AttachDto selectAttachById(int attachId);
  int insertNotice(NoticeDto noticeDto);
  int insertAttach(AttachDto attachDto);
  int deleteNotice(int noticeId);
  int updateAttachDownloadCount(int attachId);
}
