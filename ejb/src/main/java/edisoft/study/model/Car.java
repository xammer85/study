package edisoft.study.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@MappedSuperclass
public class Car extends IdObject {

	private BoardType type;
	
	private int doorsCount;
	
	private Engine engine;
	
	private List<Door> doors;

	@Column(name="board_type")
	@Enumerated(EnumType.STRING)
	public BoardType getType() {
		return type;
	}

	public void setType(BoardType type) {
		this.type = type;
	}

	
	@Column(name="doors_count")
	public int getDoorsCount() {
		return doorsCount;
	}

	public void setDoorsCount(int doorsCount) {
		this.doorsCount = doorsCount;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="engine_id")
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="car_id")
	public List<Door> getDoors() {
		return doors;
	}

	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}
	
	
	
}
