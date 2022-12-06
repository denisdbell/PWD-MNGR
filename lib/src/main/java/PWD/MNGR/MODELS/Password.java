package PWD.MNGR.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Password {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	String value;
	
	public Password(String name, String value) {
		super();		
		this.name = name;
		this.value = value;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
