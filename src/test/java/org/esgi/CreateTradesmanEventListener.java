package org.esgi;

import org.esgi.application.CreateTradesmanEvent;
import org.esgi.kernel.EventListener;

public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    @Override
    public void listenTo(CreateTradesmanEvent event) {
        System.out.println("task do when user created (maybe check user info), attach to " + event.getClass().getName());
    }
}
