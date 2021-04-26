# Project Report

Annie Peabody

## Challenge #1 Complete

In QueryEngineModule I changed

"bind(QueryEngine.class).to(**FakeQueryEngine**.class);" 

to

"bind(QueryEngine.class).to(**WikipediaQueryEngine** .class);"

## Challenge #2 Incomplete

I created a RevisionNew class and a NewRevisionFormatter class to try to change the formatting of the dates.
I spent a lot of tme trying to understand the existing code and how Instant works and how I could change it 
to LocalDateTime but I was never able to figure out how to convert the date to a new format and had to move on.

## Challenge #3 Complete

I changed the original for loop to:

String stringBuilder = response.revisions().stream().map(formatter::format).collect(Collectors.joining("\n"));

## Reflection Question #1: Functional vs OO

I prefer the iterative version if only because I have a stronger understanding of how it works compared to streams. 
To me, it looks cleaner and although it probably varies case the case ,I don't think that in this instance it was much shorter or saved more time.
I can definitely see where streams would be applicable, but I think for clarity from programmer to programmer I would prefer the iterative version.

## Reflection Question #2: Polymorphism and Dependency Inversion

Polymorphism in this application created better data abstraction so functions become more versatile and weave together and depend on one another rather than
having separate long functions that only perform a task once. The Revision class uses a lot of polymorphism as it is utilized by almost every other class in the application
despite only having a few short functions within it. Wikipedia Analyzer is an important class that relies on very few other classes but does have plenty of abstraction it depends on,
it displays strong dependency inversion.

