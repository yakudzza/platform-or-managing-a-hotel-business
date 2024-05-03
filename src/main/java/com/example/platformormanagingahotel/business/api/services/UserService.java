package com.example.platformormanagingahotel.business.api.services;


import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.exceptions.NotFoundException;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

}
