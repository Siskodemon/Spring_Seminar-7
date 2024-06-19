package com.evilcorp.Spring_Security.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//Переопределяем способ проверки пользователя
@Service
public class UserDetailService implements UserDetailsService {
    //Проверка и авторизация пользователя по введённому имени
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Пока по-умолчанию возвращаем "имеющегося" пользователя с логином "user",паролем "password" и установлеными ролями "admin" и "user"
        return new User("admin","admin", List.of(
                new SimpleGrantedAuthority("admin"),
                new SimpleGrantedAuthority("user")
        ));
    }
}
