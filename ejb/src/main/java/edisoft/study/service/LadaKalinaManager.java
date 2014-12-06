package edisoft.study.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;

import edisoft.study.data.LadaKalinaDbMpr;
import edisoft.study.model.BoardType;
import edisoft.study.model.Door;
import edisoft.study.model.Engine;
import edisoft.study.model.LadaKalina;

@Stateless
public class LadaKalinaManager implements ILadaKalinaManagerLocal {

	@EJB
	private LadaKalinaDbMpr mpr;
	
	@Override
	public LadaKalina create(int doorsCount, int power) {
		if(doorsCount <= 0)
			throw new IllegalArgumentException("Doors count can't less or equal zero!");
		
		if(power <= 0)
			throw new IllegalArgumentException("Engine power count can't less or equal zero!");
		
		LadaKalina car = new LadaKalina();
		
		List<Door> doors = new ArrayList<Door>();
		
		for (int i = 0; i < doorsCount; i++) {
			Door d = new Door();
			d.setEletricity(false);
			
			doors.add(d);
		}
		
		Engine eng = new Engine();
		eng.setHorsePower(power);
		
		car.setDoors(doors);
		car.setEngine(eng);
		
		car.setLabel("Kalina Sport");
		car.setType(BoardType.HATCHBACK);
		car.setDoorsCount(doorsCount);
		
		return mpr.create(car);
	}

	@Override
	public LadaKalina get(String id) {
		return mpr.find(id);
	}
	
}
