package edisoft.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Engine  extends IdObject {

	private int horsePower;

	@Column(name="horse_power")
	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	
	
}
