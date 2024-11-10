package LearningOOPConcept.controller;

import LearningOOPConcept.model.UpdateUserDTO;
import LearningOOPConcept.model.User;
import LearningOOPConcept.repository.UserRepo;
import LearningOOPConcept.service.UserService;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserController {
    UserService userService = new UserService();

    public TreeMap<String, User> listUser(){
        return userService.listUser();
    }
    public Set<Map.Entry<String, User>> listUserByUUID(String uuid){
       return userService.listUserByUUID(uuid);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }
    public String searchUser(String uuid) {
        return userService.searchUser(uuid);

    }

    public void updateUser(String uuid,UpdateUserDTO updateUserDTO) {
        userService.updateUser(uuid, updateUserDTO);
    }

    public void deleteUser(String uuid) {
        userService.deleteUser(uuid);
    }
}
