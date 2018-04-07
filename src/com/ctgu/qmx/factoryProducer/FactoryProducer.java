package com.ctgu.qmx.factoryProducer;

import com.ctgu.qmx.createFactory.IBaseDaoFactory;

public class FactoryProducer {
	public static IBaseDaoFactory getIBaseDaoFactory(){
		return new IBaseDaoFactory();
	}
}
