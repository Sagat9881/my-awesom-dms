package ru.apzakharov.mydbms.controllers.shellcontroller;

import org.springframework.shell.context.InteractionMode;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.apzakharov.mydbms.service.StringListMapQueryService;

@ShellComponent
public class ShellController {

    private final StringListMapQueryService service;

    public ShellController(StringListMapQueryService service) {
        this.service = service;
    }
    public ShellController() {
        this.service = new StringListMapQueryService();
    }


    @ShellMethod(key = "execute")
    public void execute(@ShellOption(value = "input") String input) {
        service.processCommand(input);
    }
}
