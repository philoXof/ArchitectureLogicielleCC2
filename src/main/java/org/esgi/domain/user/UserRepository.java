package org.esgi.domain.user;

import org.esgi.domain.user.User;
import org.esgi.domain.user.UserId;

import java.util.List;

public interface UserRepository {
    void add(User user);

    UserId nextIdentity();

    List<User> findAll();

    User findById(UserId id);
}
