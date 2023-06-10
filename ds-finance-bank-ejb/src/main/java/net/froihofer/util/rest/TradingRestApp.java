package net.froihofer.util.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


// App wird verwendet damit der Rest Service am Webserver erreichbar ist. Lässt sich alternativ auch in web.xml einrichten, steht
//    im Studienbrief.


@ApplicationPath("rs")
public class TradingRestApp extends Application {


}
