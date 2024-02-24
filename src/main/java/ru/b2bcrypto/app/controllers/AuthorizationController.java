package ru.b2bcrypto.app.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import ru.b2bcrypto.app.models.AuthUser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

@Controller
public class AuthorizationController {
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String registration() {
        try {
            ClassPathResource resource = new ClassPathResource("templates/index.html");
            Reader reader = new InputStreamReader(resource.getInputStream());

            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            return "Error reading index.html";
        }

    }

    @PostMapping (value = "/autorization", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String autorization(@ModelAttribute AuthUser authUser) {
        try {
            String login = authUser.getLogin();
            String password = authUser.getPassword();
            if (Objects.equals(login, "admin") && Objects.equals(password, "admin")) {
                ClassPathResource resource = new ClassPathResource("templates/registrationPersonal.html");
                Reader reader = new InputStreamReader(resource.getInputStream());
                return FileCopyUtils.copyToString(reader);
            } else {
                ClassPathResource resource = new ClassPathResource("templates/index.html");
                Reader reader = new InputStreamReader(resource.getInputStream());

                return FileCopyUtils.copyToString(reader);
            }
        } catch (IOException e) {
            return "Error reading index.html";
        }

    }
}
