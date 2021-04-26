package edu.bsu.cs.view;

import edu.bsu.cs.model.RevisionNew;
import java.time.format.DateTimeFormatter;

public final class NewRevisionFormatter {

    public String format(RevisionNew revision) {

        return String.format("%-25s%-20s%25s",
                revision.name,"made a change at",
                DateTimeFormatter.ISO_INSTANT.format(revision.timestamp)
                );
    }

}