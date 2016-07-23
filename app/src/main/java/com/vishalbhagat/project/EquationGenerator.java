package com.vishalbhagat.project;

import java.util.Random;

public class EquationGenerator {
	
	private int high;
	
	private int min;
	int num1;
	int num2;
	char[] operatorBegin = {'+','-','+','-','+','-','+','-'};
	char[] operatorMed =   {'+','-','X','+','X','-','X','X'};
	char[] operatorHard = {'X','^','X','^','X','/','X','/'};
	char[] operatorChall =  {'+','^','-','/','X','+','X','^'};
	
	char[] operatorCurr;
	char currentOp;
	float answer;
	Random rand;
	
	public EquationGenerator(int level) {
		super();
		
		if (level == 1)
		{
			this.high = 50;
			this.min = 2;
			this.operatorCurr = operatorBegin;
		}else if(level == 2)
		{
			this.high = 600;
			this.min = 100;
			this.operatorCurr = operatorMed ;
		}else if(level == 3)
		{
			this.high = 5000;
			this.min = 350;
			this.operatorCurr = operatorHard ;
		}
		else if(level == 4)
		{
			this.high = 6000;
			this.min = 1200;
			this.operatorCurr = operatorChall ;
		}
		rand = new Random();
	}
	

	public float getAnswer() {
		
		return this.answer;
	}
	

	public String getEquation()
	{	currentOp = operatorCurr[rand.nextInt(7)];
		num1 = rand.nextInt(high - 10) + min;
		if(currentOp == '^')
		{
			num2 = rand.nextInt(2) + 2;
			num1 = rand.nextInt(high/8) + min+10;
		}else
		{
			num2 = rand.nextInt(high/2) + min;
		}
			this.answer = calculateAnswer(num1, num2, currentOp);
		return Integer.toString(num1)+ " " + currentOp + " " +Integer.toString(num2);
		
	}

	public float calculateAnswer(int num1, int num2, char currentOp) {
		
		int i;
		int res=1;
		switch(currentOp)
		{
		case '+':
			return (float)num1+(float)num2;
		case '-':
			return (float)num1-(float)num2;
		case 'X':
			return (float)num1*(float)num2;
		case '/':
			return (float)num1/(float)num2;
		case '^':
			for(i=0;i<num2;i++)
			{
				res=res*num1;
			}
			return res;
		
		}
		return currentOp;
		
	}


	

}
