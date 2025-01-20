# Working with Entity Associations in JPA and Hibernate

- **Always synchronize both sides of the entity association.**  
  In the context of Hibernate, only synchronized bidirectional associations are guaranteed to be properly persisted in the database.  
  For synchronization, the parent entity uses specific methods for adding and removing child entities, which update references.

- **Avoid the EAGER fetching strategy.**  
  The `EAGER` strategy for `@ManyToOne` and `@OneToOne` associations can negatively affect performance.  
  Instead, it is preferable to use the `FetchType.LAZY` strategy.

- **Implement `equals` and `hashCode` methods.**  
  Implementing these methods based on the entity's identifier or business key ensures correct operation of collections in the model.  
  For entities with business keys, the `@NaturalId` annotation from Hibernate can be used.

- **Effective mapping for `@OneToOne` associations using `@MapsId`.**  
  For efficient `@OneToOne` mapping use `@MapsId` to share the primary key between the parent and child tables.  
  This allows the child entity to have the same primary key as the parent, which also serves as the foreign key.  
  This approach eliminates the need for bidirectional relationships and prevents unnecessary secondary queries.  
  Using `@MapsId` reduces the index size and enhances performance, especially with lazy loading, while preventing EAGER fetching.

## Useful Resources

- [How to synchronize bidirectional entity associations with JPA and Hibernate](https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/) - *Article by Vlad Mihalcea*
- [The best way to map a @OneToOne relationship with JPA and Hibernate](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/) - *Article by Vlad Mihalcea*
