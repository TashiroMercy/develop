package jp.co.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.co.demo.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * SpringSecurity定義クラス.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 認証の対象外にしたいURL
				.antMatchers("/encode","/webjars/**").permitAll()
				// '/admin/'で始まるURLには、'ADMIN'ロールのみアクセス可
				.antMatchers("/admin/**").hasRole("ADMIN")
				// それ以外は認証後のみ閲覧可
				.anyRequest().authenticated();

		http.formLogin()
				// ログイン処理のURL
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/menu")
				// ログイン失敗時
				.failureUrl("/")
				// パラメータ名
				.usernameParameter("id")
				.passwordParameter("password")
				.permitAll()

				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.permitAll();
	}

	/**
	 * ログイン認証クラス.
	 */
	@Configuration
	protected static class AuthenticationConfiguration  extends GlobalAuthenticationConfigurerAdapter {
		@Autowired
		UserDetailsServiceImpl userDetailsService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			// 認証するユーザーを設定する
			auth.userDetailsService(userDetailsService)
			// 入力値をbcryptでハッシュ化した値でパスワード認証を行う
			//.passwordEncoder(new BCryptPasswordEncoder())
			;
		}
	}
}