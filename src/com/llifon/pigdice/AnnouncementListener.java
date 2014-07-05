package com.llifon.pigdice;

import java.util.EventListener;

/**
 * The listener interface for receiving announcement notifications. A class that is
 * interested in capturing announcement events should implement this class and registered
 * with a notifying component. When an event is fired, the {@link #announcementReceived(String) announcementReceived}
 * method will be executed.
 */
public interface AnnouncementListener extends EventListener {

    /**
     * Invoked when an announcement notification is sent.
     * @param message The message that was announced.
     */
    void announcementReceived(String message);
}
