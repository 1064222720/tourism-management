package com.ahani.ssm.service;

import com.ahani.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;


    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;
}
