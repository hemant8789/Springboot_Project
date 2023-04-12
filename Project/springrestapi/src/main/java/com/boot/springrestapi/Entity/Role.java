package com.boot.springrestapi.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "role name is mandatory")
	private String roleName;

	public Role(Long id, @NotNull(message = "role name is mandatory") String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}


	public Role() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	public Object getRoleDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRoleDescription(Object roleDescription) {
		// TODO Auto-generated method stub
		
	}	
	
	@OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY)
    private Set<User> users;
}
