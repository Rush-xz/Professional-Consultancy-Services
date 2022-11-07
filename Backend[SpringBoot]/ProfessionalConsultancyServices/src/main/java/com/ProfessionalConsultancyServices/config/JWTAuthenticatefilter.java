package com.ProfessionalConsultancyServices.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.ProfessionalConsultancyServices.Utility.JwtUtil;
import com.ProfessionalConsultancyServices.service.CustomUserdetailservice;

@Component
public class JWTAuthenticatefilter extends OncePerRequestFilter {
	
	@Autowired
	private CustomUserdetailservice customUserdetailservice;

	@Autowired
	 private JwtUtil jwtutil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestTokenheader=request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;
		UserDetails user = null;
		
		
		if(requestTokenheader!=null && requestTokenheader.startsWith("Bearer ")) {
			jwtToken=requestTokenheader.substring(7);
			
			try {
				username=this.jwtutil.extractUsername(jwtToken);
				user=this.customUserdetailservice.loadUserByUsername(username);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
		if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UsernamePasswordAuthenticationToken unpasswordauthenticationtoken=new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
			
			unpasswordauthenticationtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(unpasswordauthenticationtoken);
			
		}
		else {
			System.out.print("Token is not valid......");
		}
		
		
		filterChain.doFilter(request, response);
		
	}

}
