package security;

public class SecurityConfig {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/companies").authenticated()
                .antMatchers(HttpMethod.DELETE,"/api/companies/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,".api/companies/{id}").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()

}
