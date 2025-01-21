# Efficient Mapping of @OneToOne Associations

## Using @MapsId for Relationships

- **Primary Key as Foreign Key**:  
  The primary key (PK) of the child entity also acts as a foreign key (FK) pointing to the parent entity. This reduces index size and enhances database performance.

## Avoiding Bidirectional Associations

- With **@MapsId**, the child entity can be retrieved using the parent entity’s identifier, eliminating the need for bidirectional mapping.

## Eliminating Additional Queries

- Hibernate uses a single query to load the child entity with **@MapsId**, avoiding secondary queries.

## Lazy Fetch for Performance Optimization

- Using **@OneToOne(fetch = FetchType.LAZY)** prevents the child entity from being automatically loaded along with the parent entity.

## No @GeneratedValue in the Child Entity

- The identifier field **(@Id)** in the child entity does not use **@GeneratedValue** since its value is derived from the parent entity.

## Flexible Column Name Configuration

- If needed, the PK/FK column name can be customized using the **@JoinColumn** annotation.

## Simplified Data Persistence and Retrieval

- Entities can be saved and retrieved directly via the parent entity's identifier:
  ```java
  PostDetails details = entityManager.find(PostDetails.class, post.getId());

## Useful Resources

- [The best way to map a @OneToOne relationship with JPA and Hibernate](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/) - *Article by Vlad Mihalcea*
