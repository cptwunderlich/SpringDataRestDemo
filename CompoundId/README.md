# CompoundId

For using compound IDs, JPA offers two mechanisms: EmbeddedId and IdClass.
The first one is an embedded object, that serves as single ID with multiple fields.
The second one means, that your Entity has multiple fields annotated with @ID and the IdClass
represents a bundled version of these fields, used for queries.

Spring Data REST can generate valid links for Entities using EmbeddedId by providing an
implementation of `BackendIdConverter`.

That doesn't work for the IdClass case: The converters `toRequestId` method recieves the first
field marked with @Id as argument, not a fully assembled IdClass.
