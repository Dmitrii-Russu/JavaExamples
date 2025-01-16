interface CustomerRepository extends JpaRepository<Customer, Long> {}

interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m JOIN FETCH m.customer WHERE m.id = :id")
    Optional<Message> findWithCustomerById(@Param("id") Long id);

    @Query("SELECT DISTINCT m FROM Message m JOIN FETCH m.customer")
    Page<Message> findAllWithCustomer(Pageable pageable);

    //Page<Message> findAll(Pageable pageable); - LazyInitializationException

}