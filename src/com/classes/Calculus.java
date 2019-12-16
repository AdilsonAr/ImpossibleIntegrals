package com.classes;

import javax.swing.JOptionPane;
import com.integrals.FresnelCx;

public class Calculus {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, calculate(0,1.77));
	}
	
	public static double calculate(double a,double b)
	{
		FresnelCx integral=new FresnelCx();
		double result=0;
		double step=(b-a)/50;
		
		int coef=1;
		boolean indi=false;
		
		double i=a;
		for(int j=0;j<=50;j++)
		{			
			coef=2;
			if(indi) coef=4;
			if(j==0|j==50) coef=1;
			result+=coef*integral.evalue(i);
			indi=!indi;
			i+=step;
		}
		return (step/3)*result;
	}
	
	
}
