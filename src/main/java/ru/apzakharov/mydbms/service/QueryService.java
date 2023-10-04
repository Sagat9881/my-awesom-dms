package ru.apzakharov.mydbms.service;

import org.springframework.stereotype.Service;

/**
 * Сервис принимает на вход команду, парсит ее в DML запрос и выполняет для хранилища данных
 *
 * @param <Q> - Тип данных, из которого нужно распарсить запрос (например String)
 * @param <S> - Тип хранилища данных, для которого пишут запросы (например List<Map<>>)
 */
public interface QueryService<Q,S> {

    void processCommand (Q inputCommand);
}
