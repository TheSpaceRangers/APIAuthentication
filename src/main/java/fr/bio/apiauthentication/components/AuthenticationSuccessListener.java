package fr.bio.apiauthentication.components;

import fr.bio.apiauthentication.entities.LoginHistory;
import fr.bio.apiauthentication.entities.User;
import fr.bio.apiauthentication.repositories.LoginHistoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        User user = (User) authentication.getPrincipal();

        String ipAddress = request.getRemoteAddr();
        if (authentication.getDetails() instanceof WebAuthenticationDetails) {
            WebAuthenticationDetails webDetails = (WebAuthenticationDetails) authentication.getDetails();
            if (webDetails != null) {
                ipAddress = webDetails.getRemoteAddress();
            }
        }

        LoginHistory loginHistory = LoginHistory.builder()
                .user(user)
                .dateLogin(LocalDateTime.now())
                .ipAddress(ipAddress)
                .build();
        loginHistoryRepository.save(loginHistory);
    }
}