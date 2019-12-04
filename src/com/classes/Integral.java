package com.classes;
public abstract class Integral {
	private Integral integral;
	private final int PARTITIONS_NUMBER=100;
	abstract public double evalue(double v);
	private double factor=1;
	
	public void setFactor(double factor)
	{
		this.factor=factor;
	}
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
		double i=a;
		for(int j=0;j<=PARTITIONS_NUMBER;j++)
		{			
			coef=2;
			if(indi) coef=4;
			if(j==0|j==PARTITIONS_NUMBER) coef=1;
			result+=coef*integral.evalue(i);
			indi=!indi;
			i+=step;
		}
		
		
		return (step/3)*result;
	}

}
