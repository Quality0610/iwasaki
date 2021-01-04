package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityCinfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    private DataSource dataSource;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    // ユーザーIDとパスワードを取得するSQL文
    private static final String USER_SQL = 
    		"SELECT"
            + "    name,"
            + "    password,"
            + "    true"
            + " FROM"
            + "    user"
            + " WHERE"
            + "    name = ?";
    

    private static final String ROLE_SQL = 
    		"SELECT"
            + "    name,"
            + "    true"
            + " FROM"
            + "    user"
            + " WHERE"
            + "    name = ?";

    
    @Override
    public void configure(WebSecurity web) throws Exception {

        //静的リソースへのアクセスには、セキュリティを適用しない
        web.ignoring().antMatchers("/webjars/∗∗", "/css/∗∗");
    }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {

       // ログイン不要ページの設定
       http
           .authorizeRequests()
               .antMatchers("/webjars/**").permitAll() //webjarsへアクセス許可
               .antMatchers("/css/**").permitAll() //cssへアクセス許可
               .antMatchers("/login").permitAll() //ログインページは直リンクOK
               .antMatchers("/signup").permitAll() //ユーザー登録画面は直リンクOK
               .anyRequest().authenticated(); //それ以外は直リンク禁止

       //ログイン処理
       http
           .formLogin()
               .loginProcessingUrl("/login") //ログイン処理のパス
               .loginPage("/login") //ログインページの指定
               .failureUrl("/login") //ログイン失敗時の遷移先
               .usernameParameter("userName") //ログインページのユーザーネーム
               .passwordParameter("password") //ログインページのパスワード
               .defaultSuccessUrl("/bbs", true); //ログイン成功後の遷移先
       
       //ログアウト処理
       http
               .logout()
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //
               .logoutUrl("/logout") //ログアウトのURL
               .logoutSuccessUrl("/login"); //ログアウト成功後のURL
       
       http.csrf().disable();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       // ログイン処理時のユーザー情報を、DBから取得する
       auth.jdbcAuthentication()
               .dataSource(dataSource)   
               .usersByUsernameQuery(USER_SQL)
               .authoritiesByUsernameQuery(ROLE_SQL)
               .passwordEncoder(passwordEncoder());
   }
}
