package com.integrals;

import com.classes.Integral;

public class Error extends Integral{

	private final String NAME="Error function";
	
	public Error()
	{
		double factor=2/Math.sqrt(Math.PI);
		this.setFactor(factor);
	}
	
	public String getName()
	{
		return NAME;
	}
	
	@Override
	public double evalue(double v) {
		return Math.pow(Math.E, -Math.pow(v, 2));
	}

}
