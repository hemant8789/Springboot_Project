package com.boot.springrestapi.Entity;
import com.boot.springrestapi.Entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name is mandatory")
	@Size(max = 100)
	private String name;
	
	@NotNull(message = "DOB must be a past date")
	private String dob;
	
	@NotBlank
	private String education;
	
	@Email(message = "Email format is invalid")
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "phone number is mandatory")
	@Pattern(regexp = "\\d{10}", message = "phone number format is invalid")
	private String phoneNumber;
	
	@NotBlank
	private String  maritalStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_role_id")
	private Role userRole;

	public User(Long id, String name, String dob, String education, String email, String phoneNumber,
			String maritalStatus, Role userRole) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.education = education;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.maritalStatus = maritalStatus;
		this.userRole = userRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", education=" + education + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", maritalStatus=" + maritalStatus + ", userRole=" + userRole + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
