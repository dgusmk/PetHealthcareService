package chatgpt.example.demo.config;

import chatgpt.example.demo.model.Admin;
import chatgpt.example.demo.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository userRepository;

    public CustomUserDetailsService(AdminRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("error: " + username);
                    return new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
                });

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}