package com.integrals;

import com.classes.Integral;

public class FresnelSx extends Integral{
	private final String NAME="Fresnel's Integral S(x)";	
	
	public FresnelSx()
	{
	}
	
	public String getName()
	{
		return NAME;
	}
	
	@Override
	public double evalue(double v) {
		return Math.sin(Math.pow(v,2));
	}

}
