package edu.bsu.cs.model;

import java.time.Instant;
import java.util.Objects;

public final class RevisionNew {

    public static final class Builder {
        private final String name;
        private Instant timestamp;

        public Builder(String name) {
            this.name = Objects.requireNonNull(name);
        }

        public RevisionNew timestamp(Instant timestamp) {
            this.timestamp = Objects.requireNonNull(timestamp);
            return new RevisionNew(this);
        }
    }

    public static Builder editor(String name) {
        return new Builder(name);
    }

    public final String name;
    public final Instant timestamp;

    private RevisionNew(Builder builder) {
        this.name = builder.name;
        this.timestamp = builder.timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RevisionNew)) {
            return false;
        }

        RevisionNew other = (RevisionNew) obj;
        return this.name.equals(other.name) && this.timestamp.equals(other.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timestamp);
    }
}
