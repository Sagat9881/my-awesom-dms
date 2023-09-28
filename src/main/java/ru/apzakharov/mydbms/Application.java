package ru.apzakharov.mydbms;

import lombok.extern.log4j.Log4j2;
import ru.apzakharov.mydbms.service.QueryService;
import ru.apzakharov.mydbms.service.StringListMapQueryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Application main class.
 */
@Log4j2
public class Application {


    public static final String SEPARATOR = "=".repeat(10);

    public static void main(final String[] args) {
        StringListMapQueryService service = new StringListMapQueryService(new ArrayList<>());
        log.info("Starting application");

        System.out.println(SEPARATOR);
        System.out.println(service.getStorage());
        System.out.println(SEPARATOR);
        service.processCommand("SELECT WHERE lastName=Киреев or id=3");
        System.out.println(SEPARATOR);
        service.processCommand("" );
        System.out.println(SEPARATOR);
        service.processCommand("SELECT WHERE id=3");
        System.out.println(SEPARATOR);
        service.processCommand("DELETE WHERE lastName=Киреев or id=3");
        System.out.println(SEPARATOR);
        System.out.println(service.getStorage());
        System.out.println(SEPARATOR);
        service.processCommand("SELECT WHERE lastName=Антонов or id=3");
        service.processCommand("SELECT WHERE lastName=Киреев or id=4");
        System.out.println(SEPARATOR);
        log.info("Exited application");

    }


}
