package ru.apzakharov.mydbms;

import lombok.extern.log4j.Log4j2;
import ru.apzakharov.mydbms.service.QueryService;
import ru.apzakharov.mydbms.service.StringListMapQueryService;

import java.util.*;

/**
 * Application main class.
 */
@Log4j2
public class Application {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String SEPARATOR = "=".repeat(10);

    public static void main(final String[] args) {
        log.info("Starting application");
        StringListMapQueryService service = new StringListMapQueryService(new ArrayList<>());
        String input = "";
        while (true) {
            input = scanner.nextLine();

            if (Objects.equals(input, "exit")) {
                break;
            }

            service.processCommand(input);
        }


        log.info("Exited application");

    }


}
