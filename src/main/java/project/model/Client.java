package project.model;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long clientid;
    Long userid;
    String adress;
    String number;
    String name;
    String surname;

    public Client() {
    }

    public Client(Long userid, String adress, String number, String name, String surname) {
        this.userid = userid;
        this.adress = adress;
        this.number = number;
        this.name = name;
        this.surname = surname;
    }

    public Client(long l, long userid, String adress, String number, String name, String surname) {
        this.userid = userid;
        this.adress = adress;
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.clientid=l;
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

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }





}
