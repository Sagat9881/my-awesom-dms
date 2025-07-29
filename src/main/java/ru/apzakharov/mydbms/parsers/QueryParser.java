package ru.apzakharov.mydbms.parsers;

import ru.apzakharov.mydbms.query.Query;
public interface QueryParser<O> {
    /**
     * Метод парсит входные данные в конкретные запросы к СУБД
     * @param input - объект, который нужно распарсить для получения объекта-запроса
     */
    <Q extends Query> Q parseQuery(O input);
}
