package ru.apzakharov.mydbms.queryprocessors;

import ru.apzakharov.mydbms.query.Query;

/**
 * Интерфейс задает контракт взаимодействия с конкретным хранилищем данных (S)
 * S - Тип хранилища, к которому нужно применить запрос
 */
public interface QueryProcessor<S> {
    <Q extends Query> S processQuery(Q query, S storage);


}
