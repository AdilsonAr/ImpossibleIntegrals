package com.classes;
public abstract class Integral {
	private Integral integral;
	private final int PARTITIONS_NUMBER=100;
	
	public double miscellaneous(double a,double b,double factor)
	{
		return 0;
	}
	
	abstract public double evalue(double v);
	private double factor=1;
	private boolean miscellaneous=false;
	
	public void setFactor(double factor)
	{
		this.factor=factor;
	}
	
	public double getFactor()
	{
		return factor;
	}
	
	public void setMiscellaneous(boolean miscellaneous)
	{
		this.miscellaneous=miscellaneous;
	}
	
	public boolean getMiscellaneous()
	{
		return miscellaneous;
	}
	
	public void setIntegral(Integral integral)
	{
		this.integral=integral;
	}
	
	public double calculate(double a,double b,double factor)
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
		
		
		return factor*(step/3)*result;
	}

}
