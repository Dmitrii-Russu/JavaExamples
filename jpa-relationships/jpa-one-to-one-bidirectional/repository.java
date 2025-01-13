interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c JOIN FETCH c.credential WHERE c.id = :id")
    Customer findWithCredentialById(Long id);

    @Query("SELECT c FROM Customer c JOIN FETCH c.credential")
    List<Customer> findAllWithCredential();
}