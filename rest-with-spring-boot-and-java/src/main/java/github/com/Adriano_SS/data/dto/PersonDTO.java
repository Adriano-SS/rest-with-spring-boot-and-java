package github.com.Adriano_SS.data.dto;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import github.com.Adriano_SS.serializer.GenderSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id", "firstName", "LastName", "address", "gender"})
@JsonFilter("PersonFilter")
public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    //@JsonProperty("Primeiro_Nome")
    private String firstName;
    private String sensitiveData;

    @JsonInclude(JsonInclude.Include.NON_NULL)  //NAO ESTA FUNCIONANDO
    private String LastName;

    private String address;
    //@JsonIgnore
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phoneNumber;

    public PersonDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() { return birthDay; }

    public void setBirthDay(Date birthDay) { this.birthDay = birthDay; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getSensitiveData() { return sensitiveData; }

    public void setSensitiveData(String sensitiveData) { this.sensitiveData = sensitiveData; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getSensitiveData(), personDTO.getSensitiveData()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getBirthDay(), personDTO.getBirthDay()) && Objects.equals(getPhoneNumber(), personDTO.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getSensitiveData(), getLastName(), getAddress(), getGender(), getBirthDay(), getPhoneNumber());
    }
}
