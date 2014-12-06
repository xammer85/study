package edisoft.study.service;

import javax.ejb.Local;

import edisoft.study.model.LadaKalina;

@Local
public interface ILadaKalinaManagerLocal {

	LadaKalina create(int doorsCount, int power);
	
	LadaKalina get(String id);
}
