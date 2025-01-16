### Managing One-to-One Relationship: Customer and Credential

#### Methods Overview

1. **`setCredential(Credential credential)`**
    - Adds or removes a relationship:
        - If `credential == null`:
            - Clears the `Customer` reference in the current `Credential`.
            - Sets `Customer.credential` to `null`.
        - If a `Credential` object is passed:
            - Sets it as `Customer.credential`.
            - Updates the reverse reference to point back to the current `Customer`.

2. **`addCredential(Credential credential)`**
    - Adds a new relationship:
        - Sets the provided `Credential` as `Customer.credential`.
        - Updates the reverse reference in `Credential`.

3. **`removeCredential()`**
    - Breaks the relationship:
        - Clears the `Customer` reference in `Credential`.
        - Sets `Customer.credential` to `null`.

#### Key Points
- **Bidirectional Sync:** Both `Customer` and `Credential` references are synchronized.
- **Cascade & Orphan Removal:** With `cascade = CascadeType.ALL` and `orphanRemoval = true`, breaking the relationship removes `Credential` from the database.
- **Usage:**
    - Use `setCredential` for simplicity (handles both add and remove).
    - Use `addCredential`/`removeCredential` for clear separation of operations.
