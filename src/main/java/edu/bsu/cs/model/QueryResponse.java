package edu.bsu.cs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class QueryResponse {

    public static final class Builder {
        private final List<RevisionNew> revisions = new ArrayList<>();
        public Builder add(RevisionNew revision) {
            revisions.add(Objects.requireNonNull(revision));
            return this;
        }
        public QueryResponse build() {
            return new QueryResponse(this);
        }
    }

    private final List<RevisionNew> revisions = new ArrayList<>();

    public QueryResponse(Builder builder) {
        revisions.addAll(builder.revisions);
    }

    public List<RevisionNew> revisions() {
        return List.copyOf(revisions);
    }
}
