package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final List<User> USERS = new ArrayList<>();
    private static long NEXT_ID = 1;

    static {
        USERS.add(new User(1L, "Alice", "alice@example.com"));
        USERS.add(new User(2L, "Bob", "bob@example.com"));
        USERS.add(new User(3L, "Charlie", "charlie@example.com"));
    }

    public List<User> findAll() {
        return USERS;
    }

    public User findById(Long id) {
        return USERS.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(NEXT_ID++);
        }
        USERS.add(user);
        return user;
    }

    public User update(Long id, User updated) {
        User existing = findById(id);
        if (existing == null) {
            return null;
        }
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        return existing;
    }

    public boolean delete(Long id) {
        return USERS.removeIf(u -> u.getId().equals(id));
    }
}
