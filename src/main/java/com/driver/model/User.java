package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username")
    String userName;

    @Column(name ="password")
    String password;

    @Column(name = "original_id")
    String originalId;

    @Column(name = "masked_id")
    String maskedId;

    @Column(name = "connected")
    Boolean connected;

    @ManyToMany
    @JoinColumn
    List<ServiceProvider> serviceProviders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Connection> connections;

    @OneToOne
    @JoinColumn
    Country country;

    public User() {
    }

    public User(int id, String userName, String password, String originalId, String maskedId, Boolean connected, List<ServiceProvider> serviceProviders, List<Connection> connections, Country country) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.originalId = originalId;
        this.maskedId = maskedId;
        this.connected = connected;
        this.serviceProviders = serviceProviders;
        this.connections = connections;
        this.country = country;
    }

    public User(String userName, String password, String originalId, String maskedId, Boolean connected) {
        this.userName = userName;
        this.password = password;
        this.originalId = originalId;
        this.maskedId = maskedId;
        this.connected = connected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getMaskedId() {
        return maskedId;
    }

    public void setMaskedId(String maskedId) {
        this.maskedId = maskedId;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public List<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
