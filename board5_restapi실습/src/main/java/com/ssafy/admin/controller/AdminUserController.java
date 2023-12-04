package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

//모든 메서드에 responsebody 할 필요 없어짐.
@RestController
@RequestMapping("/admin")
public class AdminUserController {
	
	private MemberService memberSevice;
	
	@Autowired
	public AdminUserController(MemberService memberSevice) {
		super();
		this.memberSevice = memberSevice;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userList(){
		try {
			List<MemberDto> list = memberSevice.listMember(null); //>>>>JSON Array
			if(list !=null &&!list.isEmpty()) {
				
				return new ResponseEntity<List<MemberDto>>(list,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto){
		try {
			memberSevice.joinMember(memberDto);
			List<MemberDto> list = memberSevice.listMember(null); //>>>>JSON Array
			if(list !=null &&!list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto){
		try {
			memberSevice.modifyMember(memberDto);
			List<MemberDto> list = memberSevice.listMember(null); //>>>>JSON Array
			if(list !=null &&!list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	//2개 넘겨주면 /user/{userid}/{articleno}처럼 쓸 수 있다. path variable = / requestparam
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid")String userId){
		try {
			memberSevice.deleteMember(userId);
			List<MemberDto> list = memberSevice.listMember(null); //>>>>JSON Array
			if(list !=null &&!list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userView(@PathVariable("userid")String userId){
		try {
			MemberDto memberDto= memberSevice.getMember(userId);
			if(memberDto !=null) {
				return new ResponseEntity<MemberDto>(memberDto,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error:"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
