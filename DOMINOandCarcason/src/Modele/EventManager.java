package Modele;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<EventListener> listeners = new ArrayList<>();

    public void subscribe(EventListener listener) {
        this.listeners.add(listener);
    }

    public void unsubscribe(EventListener listener) {
        this.listeners.remove(listener);
    }

    public void notify(Object data) {
        for (EventListener listener : this.listeners) {
            listener.update(data);
        }
    }
}
