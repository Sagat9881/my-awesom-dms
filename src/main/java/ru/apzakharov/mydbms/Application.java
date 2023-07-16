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


    public static void main(final String[] args) {
        StringListMapQueryService service = new StringListMapQueryService(new ArrayList<>());
        log.info("Starting application");
        service.processCommand("INSERT VALUES lastName=Федоров, id=3, age=40, active=true");
        service.processCommand("INSERT VALUES lastName=Федоров, id=4, age=40, active=true");
        service.processCommand("INSERT VALUES lastName=Федоров, id=5, age=40, active=true");
        service.processCommand("INSERT VALUES lastName=Федоров, id=6, age=40, active=true");
        service.processCommand("INSERT VALUES lastName=Киреев, id=7, age=40, active=true");
        System.out.println(service.getStorage());
        System.out.println("=".repeat(10));
        service.processCommand("DELETE WHERE lastName=Киреев or id=3");
        System.out.println(service.getStorage());
        log.info("Exited application");

    }


}
