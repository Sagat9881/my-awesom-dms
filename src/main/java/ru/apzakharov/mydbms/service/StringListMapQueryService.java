package ru.apzakharov.mydbms.service;

import ru.apzakharov.mydbms.parser.QueryParser;
import ru.apzakharov.mydbms.parser.StringParser;
import ru.apzakharov.mydbms.queryprocessors.ListMapQueryProcessor;
import ru.apzakharov.mydbms.queryprocessors.QueryProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringListMapQueryService extends AbstractQueryService<String, List<Map<String,Object>>>{
    public StringListMapQueryService() {
        super(new StringParser(), new ListMapQueryProcessor(), new ArrayList<>());
    }

    public StringListMapQueryService(List storage){
        super(new StringParser(), new ListMapQueryProcessor(), storage);
    }


}
