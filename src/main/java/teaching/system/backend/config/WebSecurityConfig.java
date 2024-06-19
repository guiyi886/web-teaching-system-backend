package teaching.system.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用HTTP Basic Authentication
        http.httpBasic().disable();
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll() // 放宽所有请求的访问控制
                .anyRequest().authenticated() // 其他请求需要身份验证
                .and()
                .csrf().disable(); // 禁用CSRF保护
    }
}
