# Working with Bidirectional Associations in JPA and Hibernate

- **Always synchronize both sides of the entity association.**  
  In the context of Hibernate, only synchronized bidirectional associations are guaranteed to be properly persisted in the database.  
  For synchronization, the parent entity uses specific methods for adding and removing child entities, which update collections or references.

- **Avoid the EAGER fetching strategy.**  
  The `EAGER` strategy for `@ManyToOne` and `@OneToOne` associations can negatively affect performance.  
  Instead, it is preferable to use the `FetchType.LAZY` strategy.

- **Implement `equals` and `hashCode` methods.**  
  Implementing these methods based on the entity's identifier or business key ensures correct operation of collections (`Set`, `List`) in the model.  
  For entities with business keys, the `@NaturalId` annotation from Hibernate can be used.

## Useful Resources

- [How to synchronize bidirectional entity associations with JPA and Hibernate](https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/) - *Article by Vlad Mihalcea*
