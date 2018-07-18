package pl.webnetix.customers.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;
    private String name, surname;
    @Embedded
    private Address address;


    public Customer() {
    }

    public Customer(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, address);
    }
}
