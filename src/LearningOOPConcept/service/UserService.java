package LearningOOPConcept.service;

import LearningOOPConcept.model.UpdateUserDTO;
import LearningOOPConcept.model.User;
import LearningOOPConcept.repository.UserRepo;

import java.util.*;


public class UserService {
    public void addUser(User user) {
        UserRepo.users.put(UUID.randomUUID().toString(), user);
    }

    public TreeMap<String, User> listUser() {

        if (UserRepo.users.isEmpty()) {
            System.out.println("=".repeat(25));
            System.out.println("No users found");
            System.out.println("=".repeat(25));
        } else {
            return UserRepo.users;
        }
        return null;
    }


    public Set<Map.Entry<String, User>> listUserByUUID(String uuid) {
        for (Map.Entry<String, User> userEntry : UserRepo.users.entrySet()) {
            if (userEntry.getKey().equals(uuid)) {
                return UserRepo.users.entrySet();
            }
        }
        return null;
    }

    public String searchUser(String uuid) {
        if (UserRepo.users.containsKey(uuid)) {
            return uuid;
        }
        return null;
    }

    public void updateUser(String uuid, UpdateUserDTO updateUserDTO) {
        User user = UserRepo.users.get(uuid);
        UserRepo.users.remove(uuid);
        user.gender = updateUserDTO.gender;
        user.name = updateUserDTO.name;
        user.age = updateUserDTO.age;
        UserRepo.users.put(uuid, user);
    }

    public void deleteUser(String uuid) {
        if (UserRepo.users.containsKey(uuid)) {
            UserRepo.users.remove(uuid);
        } else {
            System.out.println("User not found");
        }
    }
}
