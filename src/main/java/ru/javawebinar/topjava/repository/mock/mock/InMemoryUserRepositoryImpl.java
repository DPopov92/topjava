package ru.javawebinar.topjava.repository.mock.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);
    private Map<Integer,User> userRepository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);


    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        userRepository.remove(id);

        return true;
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);
        if(user.isNew()){
            user.setId(counter.incrementAndGet());
        }
        return userRepository.put(user.getId(),user);
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return userRepository.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        return userRepository.values().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);

        return getAll().stream().filter(u->u.getEmail().equals(email)).findFirst().orElse(null);
    }
}
