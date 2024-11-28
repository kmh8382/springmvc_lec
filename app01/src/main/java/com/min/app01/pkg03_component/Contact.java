package com.min.app01.pkg03_component;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Component  // 이 Contact 클래스는 contact 이름의 bean 으로 만들어집니다. (디폴트 형식의 생성자를 사용합니다.)

@NoArgsConstructor    // Contact() -> 파라미터가 없는 디폴트 생성자를 생성
@AllArgsConstructor   // Contact(String, String) -> 모든 필드 값을 파라미터로 받는 생성자를 생성
@Getter
public class Contact {
  private String mobile = "010-1111-1111";
  private String email = "user@min.com";


}
