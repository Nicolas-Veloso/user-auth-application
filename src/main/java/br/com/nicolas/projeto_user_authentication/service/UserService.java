package br.com.nicolas.projeto_user_authentication.service;

import br.com.nicolas.projeto_user_authentication.dto.UserDTO;
import br.com.nicolas.projeto_user_authentication.entity.UserEntity;
import br.com.nicolas.projeto_user_authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return new UserDTO(userRepository.save(userEntity));
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        userEntity.ifPresent(userRepository::delete);
    }
}
