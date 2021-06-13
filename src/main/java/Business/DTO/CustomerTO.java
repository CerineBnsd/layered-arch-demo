package Business.DTO;

public class CustomerTO implements TransferObject{
    private String firstName;
    private String lastName;
    private Long id;
    private Double accountBalance;

    public CustomerTO(){

    }
    public CustomerTO(Long id, String firstName, String lastName, Double accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
