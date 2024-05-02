package com.rihab.interventions.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;

import com.rihab.interventions.entities.AuthenticationResponse;
import com.rihab.interventions.entities.Role;
import com.rihab.interventions.entities.User;
import com.rihab.interventions.repos.UserRepository;
import com.rihab.interventions.util.EmailSender;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final EmailSender emailSender;
    //private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                               EmailSender emailSender
                                 //TokenRepository tokenRepository,
                                 ,AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.emailSender=emailSender;
       // this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User request) {
        try {
            // Vérifier si l'utilisateur existe déjà
            if (repository.findByUsername(request.getUsername()).isPresent()) {
                return new AuthenticationResponse(null, "L'utilisateur existe déjà");
            }

            // Générer un nom d'utilisateur automatiquement
            String login = "user" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);

            // Générer un mot de passe sécurisé
            String password = generateSecurePassword();
            
         User user = new User();
            user.setNom(request.getNom());
            user.setPrenom(request.getPrenom());
            user.setUsername(login); // Utiliser le nom d'utilisateur généré automatiquement
            user.setPassword(passwordEncoder.encode(password)); // Encodage du mot de passe sécurisé
            user.setEmail(request.getEmail());
            user.setRole(request.getRole());

            // Enregistrer l'utilisateur dans la base de données
            user = repository.save(user);
           
            // Générer le token JWT
            String jwt = jwtService.generateToken(user);
            
         // Construire le contenu de l'e-mail
            StringBuilder emailContent = new StringBuilder();
            emailContent.append("Bonjour ").append(user.getNom()).append(" ").append(user.getPrenom()).append(",\n\n");
            emailContent.append("Votre compte a été créé avec succès.\n");
            emailContent.append("Voici vos informations d'inscription :\n");
            emailContent.append("Nom d'utilisateur : ").append(login).append("\n");
            emailContent.append("Mot de passe : ").append(password).append("\n\n");
            emailContent.append("Merci de votre inscription.");

            // Envoyer l'e-mail
            emailSender.sendEmail(user.getEmail(), emailContent.toString());
     
            return new AuthenticationResponse(jwt, "Inscription de l'utilisateur réussie");
              
        } catch (Exception e) {
            return new AuthenticationResponse(null, "Erreur lors de l'enregistrement de l'utilisateur : " + e.getMessage());
        }
        
     
    }

    
    private String generateSecurePassword() {
	// TODO Auto-generated method stub
    	 return RandomStringUtils.randomAlphanumeric(10);
}/*
    public AuthenticationResponse authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            password
                    )
            );

            User user = repository.findByUsername(username).orElseThrow();
            String jwt = jwtService.generateToken(user);

            return new AuthenticationResponse(jwt, "User login was successful");
        } catch (AuthenticationException e) {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
 
*/
    
    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

      
        return new AuthenticationResponse(jwt, "User login was successful");

    }
    /*
	public AuthenticationResponse authenticate(String login, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login,
                            password
                    )
            );

            User user = repository.findByUsername(login).orElseThrow();
            String jwt = jwtService.generateToken(user);

            return new AuthenticationResponse(jwt, "User login was successful");
        } catch (AuthenticationException e) {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
    */
    
    
	/*
    public AuthenticationResponse register(User request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        User user = new User();
        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setUsername(UUID.randomUUID().toString());
      
        user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
        user.setEmail(request.getEmail());

        user.setRole(request.getRole());

        user = repository.save(user);
        // Envoyer les informations par e-mail
       // envoyerEmail(user);
        
        String jwt = jwtService.generateToken(user);

       // saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

  */
    /*// hedhya loula mt3 email:
    public AuthenticationResponse register(User request) {

        // Vérifier si l'utilisateur existe déjà
        if (repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "L'utilisateur existe déjà");
        }

        // Générer un nom d'utilisateur automatiquement
        String login = "user" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);

        // Générer un mot de passe sécurisé
        String password = generateSecurePassword();

        User user = new User();
        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setUsername(login); // Utiliser le nom d'utilisateur généré automatiquement
        user.setPassword(passwordEncoder.encode(password)); // Encodage du mot de passe sécurisé
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        // Enregistrer l'utilisateur dans la base de données
        try {
            user = repository.save(user);
        } catch (Exception e) {
            return new AuthenticationResponse(null, "Erreur lors de l'enregistrement de l'utilisateur");
        }

        // Construire le contenu de l'e-mail
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Bonjour ").append(user.getNom()).append(" ").append(user.getPrenom()).append(",\n\n");
        emailContent.append("Votre compte a été créé avec succès.\n");
        emailContent.append("Voici vos informations d'inscription :\n");
        emailContent.append("Nom d'utilisateur : ").append(login).append("\n");
        emailContent.append("Mot de passe : ").append(password).append("\n\n");
        emailContent.append("Merci de votre inscription.");

        // Envoyer l'e-mail
        emailSender.sendEmail(user.getEmail(), emailContent.toString());

        // Générer le token JWT
        String jwt = jwtService.generateToken(user);

        return new AuthenticationResponse(jwt, "Inscription de l'utilisateur réussie");
    }
/*
    // Méthode pour générer un mot de passe sécurisé
    private String generateSecurePassword() {
        // Utilisez une bibliothèque pour générer un mot de passe sécurisé, par exemple, RandomStringUtils de Apache Commons
        // Ici, je vais utiliser une chaîne aléatoire simple pour illustrer.
        return RandomStringUtils.randomAlphanumeric(10); // Génère une chaîne alphanumérique de 10 caractères
    }

  /*  
    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

      //  revokeAllTokenByUser(user);
        //saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful");

    }*/
    
    
    /*
    private void revokeAllTokenByUser(User user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }
    */
    /*
    private void saveUserToken(String jwt, User user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }*/
}