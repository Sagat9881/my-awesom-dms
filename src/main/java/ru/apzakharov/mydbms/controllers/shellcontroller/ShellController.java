package ru.apzakharov.mydbms.controllers.shellcontroller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.apzakharov.mydbms.service.QueryService;

@ShellComponent
public class ShellController {

    private final QueryService service;

    public ShellController(QueryService service) {
        this.service = service;
    }

    @ShellMethod(key = "execute")
    public void execute(@ShellOption(value = "input",arity = 10) String input) {
        service.processCommand(input);
    }
}
