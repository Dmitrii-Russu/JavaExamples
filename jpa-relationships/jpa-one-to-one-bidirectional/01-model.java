@Entity
class Customer  {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            optional = false)
    Credential credential;

    // Use either `setCredential` (which handles both setting and removing the relationship)
    // or `addCredential` and `removeCredential` for explicit separation of adding/removing relationships.

    // Adds or removes the relationship between Customer and Credential
    public void setCredential(Credential credential) {
        if (credential == null) {
            if (this.credential != null) {
                this.credential.setCustomer(null); // Breaks the relationship
            }
        }
        else {
            credential.setCustomer(this); // Sets the reverse reference in Credential
        }
        this.credential = credential;
    }

    // Adds a new relationship, explicitly setting the reverse reference
    public void addCredential(Credential credential) {
        this.credential = credential;
        if (credential != null) {
            credential.setCustomer(this); // Sets the reverse reference in Credential
        }
    }

    // Removes the relationship, explicitly clearing the reverse reference
    public void removeCredential() {
        if (this.credential != null) {
            this.credential.setCustomer(null); // Breaks the relationship
            this.credential = null;
        }
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
