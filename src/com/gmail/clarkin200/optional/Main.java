package com.gmail.clarkin200.optional;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        find(userRepository.findUserById(1L));

        find(userRepository.findUserById(4L));

        find(userRepository.findUserByEmail("renat2004@gmail.com"));

        find(userRepository.findUserByEmail("renat2005@gmail.com"));

        findAll(userRepository.findAllUsers());
    }

    public static void find(Optional<User> user) {
        if (user.isPresent()) {
            System.out.println("User is found : \n" + user.get());
        } else {
            System.out.println("User is not found");
        }
    }

    public static void findAll(Optional<List<User>> users) {
        if (users.isPresent()) {
            System.out.println("Users list is found: : \n" + users.get());
            System.out.println("Size is " + users.get().size());
        } else {
            System.out.println("Users list is not found");
        }
    }


}

