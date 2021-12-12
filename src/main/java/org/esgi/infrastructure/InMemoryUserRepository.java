package org.esgi.infrastructure;

import org.esgi.domain.user.User;
import org.esgi.domain.user.UserId;
import org.esgi.domain.user.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId,User> data = new HashMap<>();

    @Override
    public void add(User user) {
        data.put(user.getUserId(), user);
    }

    @Override
    public UserId nextIdentity() {
        return UserId.of(counter.incrementAndGet());
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(UserId id) {
        return null;
    }
}
