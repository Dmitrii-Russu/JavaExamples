interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.messages WHERE c.id = :id")
    Optional<Customer> findByIdWithMessages(@Param("id") Long id);

}