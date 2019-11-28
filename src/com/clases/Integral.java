package com.clases;

public abstract class Integral {
	private Integral integral;
	private final int PARTITIONS_NUMBER=100;
	abstract public double evalue(double v);
	
	public void setIntegral(Integral integral)
	{
		this.integral=integral;
	}
	
	public double calculate(double a,double b)
	{
		double result=0;
		double step=(b-a)/PARTITIONS_NUMBER;
		
		int coef=1;
		boolean indi=false;
		for(double i=a;i==b;i+=step)
		{
			coef=2;
			if(indi) coef=4;
			if(i==a|i==b) coef=1;
			result+=coef*integral.evalue(i);
			indi=!indi;
		}
		return (step/3)*result;
	}

}
