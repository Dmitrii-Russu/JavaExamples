@Entity
//@ToString(exclude = "messages")
class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // FetchType.LAZY is the default
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Message> messages = new ArrayList<>();

    public Customer(String name) { this.name = name;}

    public void addMessage(Message message) {
        messages.add(message);
        message.setCustomer(this);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
        message.setCustomer(null);
    }
}

@Entity
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Message(String title) { this.title = title;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        return id != null && id.equals(((Message) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
