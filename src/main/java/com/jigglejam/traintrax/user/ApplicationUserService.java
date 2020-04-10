package com.jigglejam.traintrax.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService {

    @Autowired
    ApplicationUserMapper userMapper;

    @Autowired
    ApplicationUserRepository userRepository;

    public Long create(ApplicationUserDto userDto) {
        return userRepository.save(userMapper.convertToEntity(userDto)).getId();
    }

    public ApplicationUserDto getById(Long id) {
        Optional<ApplicationUser> maybeUser = userRepository.findById(id);

        if (maybeUser.isPresent()) {
            ApplicationUser user = maybeUser.get();
            return userMapper.convertToDto(user);
        } else {
            return null;
        }
    }

    public List<ApplicationUserDto> getAll() {
        List<ApplicationUser> users = userRepository.findAll();
        return users.stream()
                .map(user -> userMapper.convertToDto(user))
                .collect(Collectors.toList());
    }
}
