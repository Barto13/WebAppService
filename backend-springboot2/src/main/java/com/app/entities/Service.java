package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "services")
public class Service {

    private long id;
    private String servicename;
    private String clientname;
    private String clientsurname;
    private String address;
    private String city;
    private int telephone;
    private String status;

    public Service() {

    }

    public Service(String servicename, String clientname, String clientsurname,
                   String address, String city, int telephone, String status) {
        this.servicename = servicename;
        this.clientname = clientname;
        this.clientsurname = clientsurname;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "servicename", nullable = false)
    public String getServicename() {
        return servicename;
    }
    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @Column(name = "clientname", nullable = false)
    public String getClientname() {
        return clientname;
    }
    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    @Column(name = "clientsurname", nullable = false)
    public String getClientsurname() {
        return clientsurname;
    }
    public void setClientsurname(String clientsurname) {
        this.clientsurname = clientsurname;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "telephone", nullable = false)
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", servicename='" + servicename + '\'' +
                ", clientname='" + clientname + '\'' +
                ", clientsurname='" + clientsurname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone=" + telephone +
                ", status='" + status + '\'' +
                '}';
    }


    //    @Override
//    public String toString() {
//        return "Service [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
//                + ", expiration=" + expiration + "]";
//    }

}
