package com.example.platformormanagingahotel.business.api.security;

import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.exceptions.NotFoundException;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import com.example.platformormanagingahotel.business.api.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;



public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private  UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            response.sendRedirect("/admin/home");
        } else {
            String username = authentication.getName();
            UserEntity user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new NotFoundException("Пользователь не найден: " + username));
            response.sendRedirect("/user/" + user.getId());
        }
    }
}