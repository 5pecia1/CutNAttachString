package sample;

import sol_5pecia1.*;

public class Main {
	
	public static void main(String[] args){
		String defaultString = "192.168.001.001";
		String dot = ".";
		
		System.out.println("default string : " + defaultString);
		
		String pureString = DivideStringInterval.makePureString(defaultString, dot);
		System.out.println("make pure string : " + pureString);
		
		String dividedString = DivideStringInterval.divideStringInterval(pureString, dot, 4);
		System.out.println("divide pure string(interval 4) : " + dividedString);
		
		String dividedPureString = DivideStringInterval.makePureNDivideStringInterval(dividedString, dot, 5);
		System.out.println("divide dividedString(interval 5) : " + dividedPureString);
		
		String appendString = "0";
		String appendedString = DivideStringInterval.append(dividedPureString, dot, 5, appendString);
		System.out.println("append string(interval 5) : " + appendedString);
		
		String deletedString = DivideStringInterval.deleteEnd(appendedString, dot, 5);
		System.out.println("delete string(interval 5) : " + deletedString);
	}
}
