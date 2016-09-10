package geppetto.module.bootsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import geppetto.module.bootsecurity.service.GpBootSecurityUserService;

@Configuration
@EnableWebMvcSecurity
/*@ComponentScan("geppetto")
@EntityScan("geppetto.module.bootsecurity.domain")*/
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
    private GpBootSecurityUserService userDetailsService;
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/user/createsocialuser");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/","/lib/**", "/app/**", "/nav1/**", "/slide/**","/source/**", "/bower_components/**").permitAll()
				
				.anyRequest().authenticated()
				.antMatchers("/app/views/en/admin/**").hasAuthority("GpAdmin")
				.and().formLogin()
				.loginPage("/#/login").permitAll().defaultSuccessUrl("/#/login-success").permitAll()
				.failureUrl("/#/login?error=true").permitAll().usernameParameter("username")
				.passwordParameter("password").and().logout().permitAll()
				.logoutSuccessUrl("/#/logout-success").and().exceptionHandling().and().csrf().disable();
	}

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }
}