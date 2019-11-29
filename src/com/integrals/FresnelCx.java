package com.integrals;

import com.clases.Integral;

public class FresnelCx extends Integral{
	private final String NAME="Fresnel's Integral C(x)";
	public FresnelCx()
	{		
	}
	
	public String getName()
	{
		return NAME;
	}
	
	@Override
	public double evalue(double v) {
		return Math.cos(Math.pow(v, 2));
	}

}
