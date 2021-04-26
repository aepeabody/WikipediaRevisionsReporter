package edu.bsu.cs.model;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class ResponseParser {

    public QueryResponse parse(InputStream in) {
        QueryResponse.Builder builder = new QueryResponse.Builder();
        DocumentContext context = JsonPath.parse(in);
        List<Map<String,String>> objects = context.read("$..revisions.*");
        for (var object : objects) {
            RevisionNew revision = makeRevisionFrom(object);
            builder.add(revision);
        }
        return builder.build();
    }

    private RevisionNew makeRevisionFrom(Map<String, String> object) {
        String name = object.get("user");
        String timestampString = object.get("timestamp");
        Instant timestamp = Instant.parse(timestampString);
        return RevisionNew.editor(name).timestamp(timestamp);
    }

}
