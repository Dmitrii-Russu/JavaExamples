@Service
@RequiredArgsConstructor
class CustomerService {
    private final EntityManager entityManager;
    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void addMessageToCustomer(Long customerId, Message message) {
        Customer customer = customerRepository.getReferenceById(customerId);
        customer.addMessage(message);
        customerRepository.save(customer);
    }

    /**
     * Adds a message to a customer.
     *
     * This implementation reduces the number of SQL queries by directly
     * managing the relationship and persisting the new message entity
     * without re-saving the customer entity.
     */

	@Transactional
	public void addMessageToCustomer(Long customerId, Message message) {
		Customer customer = entityManager.getReference(Customer.class, customerId);
		message.setCustomer(customer);
		entityManager.persist(message);
	}
}