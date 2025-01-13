@Entity
class Customer  {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}

@Entity
class Credential  {
    @Id
    private Long id;
    private String password;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;
}