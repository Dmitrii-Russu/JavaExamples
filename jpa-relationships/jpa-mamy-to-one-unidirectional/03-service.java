@Service
@RequiredArgsConstructor
class CustomerService {
    private final CustomerRepository customerRepository;
    private final MessageRepository messageRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public void createMessage(Long id, Message message) {
        Customer customer = customerRepository.getReferenceById(id);
        message.setCustomer(customer);
        messageRepository.save(message);
    }

    public List<Message> findAllWithCustomer(int page, int size) {
        Sort sort = Sort.by("title").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return messageRepository.findAllWithCustomer(pageable).getContent();
    }

}