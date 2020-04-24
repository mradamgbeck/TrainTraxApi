package com.jigglejam.traintrax.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class ApplicationUserController {
    @Autowired
    private ApplicationUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Long create(@RequestBody ApplicationUserDto userDto) {
        return userService.create(userDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApplicationUserDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public ApplicationUserDto getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<ApplicationUserDto> getAll() {
        return userService.getAll();
    }
}
