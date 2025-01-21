# Best Practices for Mapping a `@ManyToOne` Association with JPA and Hibernate

## Use the `@ManyToOne` Annotation

- For "many-to-one" relationships, use the `@ManyToOne` annotation, which automatically creates a foreign key to link the parent entity.
- It is recommended to set the fetch strategy to `FetchType.LAZY` to avoid performance issues like the N+1 query problem.

## Avoid `FetchType.EAGER`

- The `FetchType.EAGER` strategy can lead to performance bottlenecks, as it loads related entities even when they are not needed.
- Instead, prefer `FetchType.LAZY`, which loads data only when accessed.

## Persisting a `@ManyToOne` Association

- When saving a child entity, use the `getReference` method instead of `find` to prevent unnecessary queries for the parent entity.
- In Spring Data JPA, you can use the `getReferenceById` method for this purpose.

## Useful Resources

- [ManyToOne JPA and Hibernate Association Best Practices](https://vladmihalcea.com/manytoone-jpa-hibernate/) - *Article by Vlad Mihalcea*
