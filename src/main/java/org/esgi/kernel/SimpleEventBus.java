package org.esgi.kernel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SimpleEventBus<E extends Event> implements EventBus<E> {

    private final Map<Class<? extends E>, List<EventListener<? extends E>>> associatedListeners = new HashMap<>();

    @SuppressWarnings("all")
    @Override
    public void publish(E event) {

        var eventListeners = this.associatedListeners.get(event.getClass());
        if (eventListeners == null) {
            //Do nothing
            return;
        }

        for (EventListener eventListener : eventListeners) {
            eventListener.listenTo(event);
        }
    }

    @Override
    public void register(Class<? extends E> classE, List<EventListener<? extends E>> eventListeners) {
        this.associatedListeners.put(classE, eventListeners);
    }
}
