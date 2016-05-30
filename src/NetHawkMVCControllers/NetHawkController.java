/*
 * Copyright 2016
 * William Alexander
 *
 * This is the Controller in a MVC pattern.  It starts the Model and View and then starts the infinite
 * loop.
 *
 * Every 10 minutes (600 s) the controller tests that the DNS servers are up.  If the servers aren't
 * up, indicate there has been a DNS error to the View.
 *
 * Provide a mechanism for the Controller to clear accumulated DNS errors.
 */
package NetHawkMVCControllers;

import NetHawkMVCViews.*;
import NetHawkMVCModels.*;

public class NetHawkController {
    private static NetHawkModel nhModel = new NetHawkModel();
    private static NetHawkView nhView = new NetHawkView();

    public void startApplication() {
        final int MILLISECONDS = 1000;

        while(true) {
            if(nhModel.testDNS() == 0) {
                nhView.indicateDNSError();
            }
            try { Thread.sleep(600 * 1000); } catch(Exception e) { throw new RuntimeException(e); }
        }
    }

    public void clearEvents() {
        nhModel.foundDNSError = 0;
        nhView.clearDNSError();
    }
}