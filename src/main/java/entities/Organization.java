package entities;

import java.util.Set;

public class Organization {
 private  int Organization_id;
 private  String Name_of_organization;
 private  String Phone;
 private  String E_mail;
 private Set<Cd> cds;

    public Set<Cd> getCds() {
        return cds;
    }
     public Organization(){
     }
    public void setCds(Set<Cd> cds) {
        this.cds = cds;
    }

    public Organization(int org_id, String name_of_organization, String phone, String e_mail, Set<Cd> cds) {
        Organization_id = org_id;
        Name_of_organization = name_of_organization;
        Phone = phone;
        E_mail = e_mail;
        this.cds = cds;
    }

    public int getOrganization_id() {
        return Organization_id;
    }

    public void setOrganization_id(int organization_id) {
        Organization_id = organization_id;
    }

    public String getName_of_organization() {
        return Name_of_organization;
    }

    public void setName_of_organization(String name_of_organization) {
        Name_of_organization = name_of_organization;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "Org_id=" + Organization_id +
                ", Name_of_organization='" + Name_of_organization + '\'' +
                ", Phone='" + Phone + '\'' +
                ", E_mail='" + E_mail + '\'' +
                '}';
    }
}

