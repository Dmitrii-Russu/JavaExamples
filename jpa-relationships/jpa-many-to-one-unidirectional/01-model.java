@Entity
class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}

@Entity
//@ToString(exclude = "customer")
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}