/*
 * Copyright 2016
 * William Alexander
 *
 * This simple program is an example of using a Model-View-Controller design pattern.
 *
 * The main() routine starts the application (a System Tray icon) via the controller which runs an infinite loop
 * testing DNS lookups.  If a lookup fails, the icon is turned red.  Clicking on the System Tray icon resets the
 * error detection flag and turns the System Tray icon green again.
 *
 */
package NetHawkMain;

// Import the Controller package.
import NetHawkMVCControllers.*;

public class NetHawk {
    public static void main(String[] args) {
        // Start the application.
        NetHawkController nhController = new NetHawkController();
        nhController.startApplication();
    }
}
