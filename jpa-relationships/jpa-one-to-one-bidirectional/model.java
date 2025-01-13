@Entity
class Customer  {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    Credential credential;

    public void setCredential(Credential credential) {
        if (credential == null) {
            if (this.credential != null) {
                this.credential.setCustomer(null);
            }
        }
        else {
            credential.setCustomer(this);
        }
        this.credential = credential;
    }
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