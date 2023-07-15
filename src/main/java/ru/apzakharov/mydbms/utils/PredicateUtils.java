package ru.apzakharov.mydbms.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

@UtilityClass
public class PredicateUtils {

    public static final String OR = "or";
    public static final String AND = "and";
    public static final String GREATER = ">";
    public static final String LESS = "<";
    public static final String EQUALS = "=";

    public static <Q extends Comparable<Q>> Predicate<Map<String, Q>> less(String key, Q filter) {
        return (store) -> store.get(key).compareTo(filter) < 0;
    }

    public static <Q extends Comparable<Q>> Predicate<Map<String, Q>> greater(String key, Q filter) {
        return (store) -> store.get(key).compareTo(filter) > 0;
    }

    public static <Q extends Comparable<Q>> Predicate<Map<String, Q>> equals(String key, Q filter) {
        return (store) -> store.get(key).compareTo(filter) == 0;
    }

    public static Predicate and(Predicate... one) {
        return Arrays.stream(one).reduce((pred, pred1) -> pred.and(pred1)).orElse(null);
    }

    public static Predicate or(Predicate one, Predicate two) {
        return one.or(two);
    }

    public static Predicate<Map<String, Object>> buildPredicateFromString(String input) {
        final String[] tokens = input.split(" ");
        Predicate predicate = null;
        boolean containsEscapeSequence = input.contains(OR) || input.contains(AND);
        if (containsEscapeSequence) {
                if (input.contains(OR)) {
                    String[] or = input.split(OR);
                    predicate = or(
                              buildPredicateFromString(or[0])
                            , buildPredicateFromString(or[1])
                    );
                }
                if (input.contains(AND)) {
                    String[] and = input.split(AND);
                    predicate = and(
                              buildPredicateFromString(and[0])
                            , buildPredicateFromString(and[1])
                    );
                }
        } else {
                if (input.contains(LESS)) {
                    String[] split = input.split(LESS);
                    Comparable value = split[1];
                    predicate = predicate == null ? less(split[0], value) : predicate.and(less(split[0], value));
                }

                if (input.contains(EQUALS)) {
                    String[] split = input.split(EQUALS);
                    Comparable value = split[1];
                    predicate = predicate == null ? equals(split[0], value) : predicate.and(equals(split[0], value));
                }

                if (input.contains(GREATER)) {
                    String[] split = input.split(GREATER);
                    Comparable value = split[1];
                    predicate = predicate == null ? greater(split[0], value) : predicate.and(greater(split[0], value));
                }
        }
        return predicate;
    }
}
