package jp.co.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                認証の対象外にしたいURLがある場合には、以下のような記述を追加します
//                複数URLがある場合はantMatchersメソッドにカンマ区切りで対象URLを複数列挙します
//                .antMatchers("/country/**").permitAll()
                .antMatchers("/encode").permitAll()
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/menu")
                .failureUrl("/")
                .usernameParameter("id")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 独自認証クラスを設定する
        auth
        .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");
        auth
       .inMemoryAuthentication()
            .withUser("admin").password("password").roles("ADMIN");
    }
}