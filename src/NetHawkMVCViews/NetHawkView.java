
/*
 * Copyright 2016
 * William Alexander
 *
 * This is the View in a MVC pattern.  It starts the Model and View and then starts the infinite
 */
package NetHawkMVCViews;

// Import UI packages.
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

// Import the Controller package.
import NetHawkMVCControllers.*;

public class NetHawkView {
    private final String ICON_PATH = "C:/Users/William/IdeaProjects/NetHawk/";
    private final String DEFAULT_ICON = "wireless_router_green.png";
    private final String ERROR_ICON= "wireless_router_red.png";
    private final String APP_NAME = "NetHawk";

    private NetHawkController nhController = new NetHawkController();
    final private TrayIcon trayIcon = new TrayIcon(new ImageIcon(ICON_PATH + DEFAULT_ICON, "omt").getImage(), APP_NAME);

    public NetHawkView() {
        createView();
    }

    // Create the System Tray icon.
    private void createView() {
        /*
         * Establish a System Tray icon.
         */
        if (SystemTray.isSupported()) {
            final SystemTray systemTray = SystemTray.getSystemTray();
            trayIcon.setImageAutoSize(true);// Autosize icon base on space

            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nhController.clearEvents();
                }
            };
            trayIcon.addMouseListener(mouseAdapter);
            try { systemTray.add(trayIcon); } catch (Exception e) { throw new RuntimeException(e); }
        }
    }

    // Provide the Controller with a way to indicate there's a DNS error.
    public void indicateDNSError() {
        trayIcon.setImage(new ImageIcon(ICON_PATH + ERROR_ICON, "omt").getImage());
    }

    // Provide the Controller with a way to indicate there's no longer a DNS error.
    public void clearDNSError() {
        trayIcon.setImage(new ImageIcon(ICON_PATH + DEFAULT_ICON, "omt").getImage());
    }
}