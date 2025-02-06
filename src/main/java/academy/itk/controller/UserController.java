package academy.itk.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public record UserController() {

    @GetMapping("/user")
    public Map<String, Object> getPrincipalUser(@AuthenticationPrincipal OAuth2User principal) {
        return new HashMap<>(){{
            put("name", principal.getAttribute("name"));
            put("login", principal.getAttribute("login"));
            put("id", principal.getAttribute("id"));
            put("email", principal.getAttribute("email"));
        }};
    }
}
