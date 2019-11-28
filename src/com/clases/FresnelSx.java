package com.clases;

public class FresnelSx extends Integral{
	private String nombre="Fresnel's Integral S(x)";
	public FresnelSx()
	{
		
	}
	@Override
	public double evalue(double v) {
		return Math.sin(Math.pow(v, 2));
	}

}
