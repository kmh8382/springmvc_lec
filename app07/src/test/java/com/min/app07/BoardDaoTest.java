package com.min.app07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.app07.dao.IBoardDao;

/*
 * IBoardDao 타입의 구현체 BoardDaoImpl bean은 @Repository를 이용해 생성하였으므로 Component Scan이 정의되어 있는 servlet-context.xml 파일이 필요합니다.
 * BoardDaoImpl 클래스의 필드인 SqlSessionTemplate bean은 root-context.xml 파일에 <bean> 태그를 이용해서 생성하였습니다. 
 */

@SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                              "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
class BoardDaoTest {

  // Spring Container에 저장된 IBoardDao 타입의 bean 가져오기
  @Autowired
  private IBoardDao boardDao;
  
  @Test
  void 목록테스트() {
    // 두 번째 항목의 contents="대방어, 광어, 우럭 매운탕" 인지 테스트
    assertEquals(true, boardDao.selectBoardList().get(1).getContents().startsWith("대방어"));
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
