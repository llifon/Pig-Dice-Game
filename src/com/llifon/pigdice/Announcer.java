package com.llifon.pigdice;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a state announcer for the game of pig.
 */
public final class Announcer {

    /**
     * A collection of all listeners which should be notified
     * when an announcement is made.
     */
    private final List<AnnouncementListener> listeners;

    /**
     * Constructs a default Announcer which has no active listeners.
     */
    public Announcer()
    {
        this.listeners = new ArrayList<>();
    }

    /**
     * Attaches a listener object to the announcer. When a message is
     * announced, all listeners registered via this method will be notified.
     * @param listener
     */
    public void addAnnouncementListener(AnnouncementListener listener)
    {
        this.listeners.add(listener);
    }

    /**
     * Detaches a listener object from the announcer. When a message is announced,
     * the previously attached listener will no longer be notified.
     * @param listener
     */
    public void removeAnnoucementListener(AnnouncementListener listener)
    {
        this.listeners.remove(listener);
    }

    /**
     * Announces the specified state message to all listeners.
     * @param message The message to announce.
     */
    public void announce(String message)
    {
        this.listeners
                .parallelStream()
                .filter(e -> e != null)
                .forEach(e -> e.announcementReceived(message));
    }

    /**
     * Announces the specified state message to all listeners.
     * @param format The message format.
     * @param values The formatting values.
     */
    public void announce(String format, Object... values)
    {
        this.announce(String.format(format,values));
    }
}
