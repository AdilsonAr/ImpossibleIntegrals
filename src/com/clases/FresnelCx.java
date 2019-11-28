package com.clases;

public class FresnelCx extends Integral{
	private String nombre="Fresnel's Integral C(x)";
	public FresnelCx()
	{
		
	}
	@Override
	public double evalue(double v) {
		return Math.cos(Math.pow(v, 2));
	}

}
