package tr.com.mindworks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/login.xhtml", "/resources", "/fonts/**", "/javax.faces.resource/**", "/console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login.xhtml")
                .and()
                .csrf()
                .disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.xhtml")
                .invalidateHttpSession(true)
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.expressionHandler(new DefaultWebSecurityExpressionHandler()
        {
            @Override
            protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi)
            {
                WebSecurityExpressionRoot root = (WebSecurityExpressionRoot) super.createSecurityExpressionRoot(authentication, fi);
                return root;
            }
        });
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("mindworks")
			.password("m")
			.roles("USER");
	}
}
