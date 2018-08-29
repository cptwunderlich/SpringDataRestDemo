# Minimal working examples showing some issues with Spring Data REST

* NamedEntityGraphIgnored - NamedEntityGraph on repository method, but is not applied when queried via REST

* AssociationSort - Sorting a collection resource by a linked entities property is not possible (even though Spring Data could do it) 

* CompoundId - Creating valid entity links with @IdClass IDs with Spring Data REST doesn't work with BackendIdConverter
