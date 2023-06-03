package com.driver.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="service_provider")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn
    Admin admin;

    @ManyToMany(mappedBy = "serviceProviders")
    List<User> users;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    List<Connection> connections;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    List<Country> countrys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Country> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<Country> countrys) {
        this.countrys = countrys;
    }

    public ServiceProvider(int id, String name, Admin admin, List<User> users, List<Connection> connections, List<Country> countrys) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.users = users;
        this.connections = connections;
        this.countrys = countrys;
    }

    public ServiceProvider() {
    }

    public ServiceProvider(String name) {
        this.name = name;
    }
}
