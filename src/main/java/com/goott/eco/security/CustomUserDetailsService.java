package com.goott.eco.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.goott.eco.domain.CustVO;
import com.goott.eco.mapper.CustMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Setter(onMethod_ = {@Autowired})
	private CustMapper custMapper;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) 
		throws UsernameNotFoundException {
		
		log.warn("Load User By UserName :"+ memberId);
		
		//userName means userid
		CustVO custVO = custMapper.getCustAuth(memberId);
		
		log.warn("MemberMapper쿼리 사용: "+custVO);
		 
		return custVO == null ? null : new CustomUser(custVO);
	}
	

}
