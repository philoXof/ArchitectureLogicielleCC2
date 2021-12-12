package org.esgi.application;

import org.esgi.domain.user.User;
import org.esgi.domain.user.UserRepository;
import org.esgi.kernel.ApplicationEvent;
import org.esgi.kernel.EventBus;

public class UserService {

    private final UserRepository userRepository;
    //private final EventBus<ApplicationEvent> eventBus;

    public UserService(UserRepository userRepository/*, EventBus<ApplicationEvent> eventBus*/) {
        this.userRepository = userRepository;
        //this.eventBus = eventBus;
    }

    public void create(User user) {
        this.userRepository.add(user);
        //this.eventBus.publish(new event class to create in application package);
    }

}
