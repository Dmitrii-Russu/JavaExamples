
interface CredentialRepository extends JpaRepository<Credential, Long> {

    @Query("SELECT c FROM Credential c JOIN FETCH c.customer WHERE c.id = :id")
    Optional<Credential> findWithCustomerById(@Param("id") Long id);

    @Query("SELECT c FROM Credential c JOIN FETCH c.customer")
    List<Credential> findAllWithCustomer();
}