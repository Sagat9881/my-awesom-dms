package ru.apzakharov.mydbms.query;

import java.util.function.Predicate;

public class SelectQuery implements Query {
    @Override
    public QueryType getType() {
        return QueryType.SELECT;
    }

    @Override
    public <Q> Predicate<Q> getPredicate() {
        return null;
    }
}
