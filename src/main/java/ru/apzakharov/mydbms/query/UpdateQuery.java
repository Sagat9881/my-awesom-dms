package ru.apzakharov.mydbms.query;

import java.util.Map;
import java.util.function.Predicate;

public class UpdateQuery implements Query {
    @Override
    public QueryType getType() {
        return QueryType.UPDATE;
    }

    @Override
    public <Q> Predicate<Q> getPredicate() {
        return null;
    }

    public Map<String, Object> getTokensWithValue() {
        return null;
    }
}
