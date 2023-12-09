package com.poly.security;

import com.poly.model.KhachHang;
import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountService userDAO;


    /*--Mã hóa mật khẩu--*/
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            KhachHang user=userDAO.findById(username);
            String password=user.getMatKhau();
            String role=String.valueOf(user.getQuyen().getMaQuyen());
            return User.withUsername(username)
                    .password(getPasswordEncoder().encode(password))
                    .roles(role).build();
        } catch (Exception e) {
            throw new UsernameNotFoundException(username+"not found");
        }
    }

}
