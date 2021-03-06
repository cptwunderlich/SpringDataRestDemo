# SpringDataRestAssociationSort

MWE of spring data rest not sorting collection resource by associated entities property.

This example contains two Entities, `Article` and `Unit`, where these two have a ManyToOne relationship.
The test `AssocsortApplicationTests.java` contains a unit test for a simple JPA query, selecting all Articles
and sorting them by the name of the unit. Since that is the key, not even a join is necessary.
The second test uses `Unit.fullName` for sorting, but JPA is intelligent enough to do a Join, so all is well.

Since we added QueryDsl, we can issue REST queries with filters. We can filter by our unit like this:

    curl -i -X GET "http://localhost:8080/articles?unit.code=pc"

But sorting via REST like so:

    curl -i -X GET "http://localhost:8080/articles?sort=unit.code,desc"

does not work however.
