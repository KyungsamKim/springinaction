package com.ssafy.board.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// getter 만들기
@Getter
//setter 만들기
@Setter
//ToString 
@ToString
//기본 생성자 
@NoArgsConstructor
// 모든 변수를 사용하는 생성자를 자동 완성
@AllArgsConstructor
@RequiredArgsConstructor
@Data // 위의 설정들을 모두 담고 있음.
public class BoardDto {
	//NonNull or final로 해주면 required 생성자 생성
	@NonNull
	private int articleNo;
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private List<FileInfoDto> fileInfos;

}
