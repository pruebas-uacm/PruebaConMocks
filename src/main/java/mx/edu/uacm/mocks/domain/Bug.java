package mx.edu.uacm.mocks.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Bug {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private  String title;
	
	@Lob
	private String description;
	
	public Bug() {
		// TODO Auto-generated constructor stub
	}
	
	public Bug(Long id, String title, String desc) {
		this.id = id;
		this.title = title;
		this.description = desc;
	}
	
	
}
