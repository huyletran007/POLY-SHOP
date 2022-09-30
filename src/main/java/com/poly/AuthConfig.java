package com.poly;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.entity.Account;
import com.poly.service.AccountService;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder pe;

	@Autowired
	AccountService accountService;

	@Autowired
	HttpSession session;
	
	// Cung cấp nguồn dữ liệu đăng nhập
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username->{
			try {
				Account user = accountService.findById(username);
				
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream()
						.map(el->el.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException(username + "not found!");
			}
		});
	}
		
		// Phân quyền sử dụng
		@Override
		protected void configure(HttpSecurity http) throws Exception {	
			http.csrf().disable();
			http.authorizeRequests()
				.antMatchers("/order/**","/login/success","/login/success/**").authenticated()
				.antMatchers("/admin/**").hasAnyRole("STAFF", "ADMIN")
				.antMatchers("/rest/authorities","/login/success2").hasAnyRole("ADMIN")
				.anyRequest().permitAll();
			
			http.formLogin()
				.loginPage("/login")		
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/login/success", false)
				.failureUrl("/login/error");

			http.rememberMe()
				.tokenValiditySeconds(86400);
			
			http.exceptionHandling()
				.accessDeniedPage("/unauthoried");
			
			http.logout()
				.logoutUrl("/logoff")
				.logoutSuccessUrl("/logoff/success");		
		}
		
		// Cơ chế mã hóa mật khẩu
		@Bean
		public BCryptPasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		// Cho phép truy xuất REST API từ domain khác
		@Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	    }
}
