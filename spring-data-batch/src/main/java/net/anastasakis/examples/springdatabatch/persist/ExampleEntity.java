package net.anastasakis.examples.springdatabatch.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author cyrus
 *
 */
@Entity
public class ExampleEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private long id;
	
	@Column
	private String exampleText;

	public ExampleEntity(String exampleText) {
		this.exampleText = exampleText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exampleText == null) ? 0 : exampleText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExampleEntity other = (ExampleEntity) obj;
		if (exampleText == null) {
			if (other.exampleText != null)
				return false;
		} else if (!exampleText.equals(other.exampleText))
			return false;
		return true;
	}
}
