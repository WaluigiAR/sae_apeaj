package com.webapp.ytb.webappytp.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webapp.ytb.webappytp.modele.Etudiant;
import com.webapp.ytb.webappytp.repository.EtudiantRepository;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private EtudiantRepository etudiantRepository;

    public CustomUserDetailsService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Etudiant user = etudiantRepository.findUserByLogin(login);
        List<String> roles = Arrays.asList(user.getRole().toString());
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getLogin())
                        .password(user.getMdp())
                        .roles(user.getRole().toString())
                        .build();

        return userDetails;
    }
}