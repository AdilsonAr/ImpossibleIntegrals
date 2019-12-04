package com.integrals;

import com.classes.Integral;

public class ErrorC extends Integral{

	private final String NAME="Complementary error function";
	public ErrorC()
	{
		this.setMiscellaneous(true);
	}
	
	public String getName()
	{
		return NAME;
	}
	
	@Override
	public double evalue(double v) {
		return 0;
	}

	@Override
	public double miscellaneous(double a, double b, double factor) {
		double result=0;
		Error e=new Error();
		e.setIntegral(e);
		e.setFactor(e.getFactor());
		result=1-e.calculate(0, b, e.getFactor());
		return result;
	}
	
	

}
