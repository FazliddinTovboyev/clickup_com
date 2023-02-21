package com.example.clickup_com.service;

import com.example.clickup_com.dto.APIResponse;
import com.example.clickup_com.dto.LoginDTO;
import com.example.clickup_com.dto.UserDTO;
import com.example.clickup_com.entity.Users;
import com.example.clickup_com.entity.enums.SystemRoleName;
import com.example.clickup_com.repository.UserRepository;
import com.example.clickup_com.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenGenerator tokenGenerator;
    public APIResponse registerUserService(UserDTO userDTO) {
        Optional<Users> byUsername = userRepository.findByUsername(userDTO.getUsername());
        if (byUsername.isPresent()) {
            return new APIResponse(false,"Bunday email allaqachon ro'yhatdan o'tgan");
        }
        int emailkod = new Random().nextInt(999,10000);
        Users users = new Users(
                userDTO.getFish(),
                userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getAvatarRangi(),
                userDTO.getPlatformaRangi(),
                SystemRoleName.USER,
                String.valueOf(emailkod)
        );
        if(xabaryuborish(users.getUsername(), users.getEmailCode())){
            userRepository.save(users);
            return new APIResponse(true,"Siz ro'yhatdan o'tdingiz✅✅ Emailga tasdiqlash kodi yuborildi✅");
        }
        return new APIResponse(false,"Yuborilmadi");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        }
        return (UserDetails) new UsernameNotFoundException("Topilmadi");
    }

    public APIResponse emailtasdiqlash(String email, String email_kod) {
        Optional<Users> byUsernameAndEmailpassword = userRepository.findByUsernameAndEmailCode(email, email_kod);
        if (byUsernameAndEmailpassword.isPresent()) {
            Users users = byUsernameAndEmailpassword.get();
            users.setEnabled(true);
            users.setEmailCode(null);
            userRepository.save(users);
            return new APIResponse(true,"Profil faollashtirildi");
        }
        return new APIResponse(false,"Profil allaqachon faollashtirilgan");
    }

    public boolean xabaryuborish(String email,String email_kod){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@baeldung.com");
            helper.setTo(email);
            helper.setSubject("Email tasdiqlash");
            helper.setText("<button style=\"width: 100px;height:50px;box-shadow: 0px 0px 20px blueviolet; border-radius:10px; background: rgb(113, 0, 218); border: none; margin: 50px 100px; padding: 15px;\"><a href=\"http://localhost:8080/user/tasdiqlash?email="+email+"&email_kod="+email_kod+"\" style=\"text-decoration: none; color: white; font-size: 16px; text-shadow: 0 0 10px white;\">Tasdiqlash</a></button>",true);
            javaMailSender.send(message);
            return  true;
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return false;
    }

    public APIResponse login(LoginDTO loginDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
            Users users = (Users) authenticate.getPrincipal();
            if (!users.isEnabled()) {
                return new APIResponse(false,"Faollashtirish linki bosilmagan");
            }
            String token = tokenGenerator.token(users.getUsername());
            return new APIResponse(true,"Platformaga kirildi: "+token);
        }
        catch (BadCredentialsException badCredentialsException){
            return new APIResponse(false,"Login yoki parol xato");
        }
    }
}
