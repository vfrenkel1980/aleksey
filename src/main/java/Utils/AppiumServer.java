package Utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppiumServer {

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private String ipAddress;
    private String deviceName;
    private int port;

    Logger log = LogManager.getLogger( );
    File classPathRoot = new File(System.getProperty("user.dir"));


    public void startNewServer(String ipAddress, int port,String deviceName) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.deviceName = deviceName;
        log.info("Start Appium Server");
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress(ipAddress)
                .usingPort(port)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(new File(classPathRoot, File.separator + "log"), date+" "+deviceName+" "+ "Log.txt"));


        service = AppiumDriverLocalService.buildService(builder);
        service.start();

    }

    public void  stopNewServer(){
        log.info("Stop Appium Server");
        service.stop();
    }
}
