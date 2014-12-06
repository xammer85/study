package edisoft.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="car_door")
public class Door  extends IdObject{

	private Boolean eletricity;

	@Column
	public Boolean getEletricity() {
		return eletricity;
	}

	public void setEletricity(Boolean eletricity) {
		this.eletricity = eletricity;
	}
}
