package com.gmail.clarkin200.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Renat", "renat2005@gmail.com"));
        users.add(new User(2L, "Ilya", "ilyalis2004@gmail.com"));
        users.add(new User(3L, "Nika", "nika2007@gmail.com"));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        if (users.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(users);
        }
    }
}
