package sample;

import sol_5pecia1.CutNAttachStringInterval;
import sol_5pecia1.money_comma.MoneyComma;
import sol_5pecia1.money_comma.exception.NotMoneyException;
import sol_5pecia1.money_comma.exception.NotValidNumberException;

//TODO make detail test
public class Main {
	
	public static void main(String[] args){
		Main main = new Main();
		
		main.startSample();
	}
	
	public void startSample(){
		useCutNAttachStringInterval();
		System.out.println("===========================");
		useMoneyComma();
	}
	
	private void useCutNAttachStringInterval(){
		String defaultString = "192.168.001.001";
		String dot = ".";
		
		System.out.println("default string : " + defaultString);
		
		String pureString = CutNAttachStringInterval.makePureString(defaultString, dot);
		System.out.println("make pure string : " + pureString);
		
		String dividedString = CutNAttachStringInterval.divideString(pureString, dot, 4);
		System.out.println("divide pure string(interval 4) : " + dividedString);
		
		String dividedPureString = CutNAttachStringInterval.makePureNDivideString(dividedString, dot, 5);
		System.out.println("make pure and divide string(interval 5) : " + dividedPureString);
		
		String appendString = "0";
		String appendedString = CutNAttachStringInterval.append(dividedPureString, dot, 5, appendString);
		System.out.println("append string(interval 5) : " + appendedString);
		
		String deletedString = CutNAttachStringInterval.deleteEnd(appendedString, dot, 5);
		System.out.println("delete string(interval 5) : " + deletedString);
	}
	
	private void useMoneyComma(){
		String defualtMoney = "1,234.56";
		
		System.out.println("defualt money : " + defualtMoney);
		
		String pureMoney;
		try {
			pureMoney = MoneyComma.makePure(defualtMoney);
			Double moneyDuble = Double.parseDouble(pureMoney);
			System.out.println("make type Double : " + (moneyDuble instanceof Double) + " / result : " + moneyDuble);
			
			String commaMoney = MoneyComma.divide(pureMoney, 3);
			System.out.println("pureMoney divide comma : " + commaMoney);
			
			String appendMoney = "12";
			String haveNotDotMoney = "789";
			System.out.println(commaMoney + " append " + appendMoney + " : " + MoneyComma.append(commaMoney, 3, appendMoney));
			System.out.println(haveNotDotMoney + " append " + appendMoney + " : " + MoneyComma.append(haveNotDotMoney, 3, appendMoney));
			
			String deleteMoney = MoneyComma.deleteEnd(commaMoney, 3);
			System.out.println(commaMoney + " deleteEnd : " + deleteMoney);
			System.out.println(deleteMoney + " deleteEnd : " + MoneyComma.deleteEnd(deleteMoney, 3));
			System.out.println(haveNotDotMoney + " deleteEnd : " + MoneyComma.deleteEnd(haveNotDotMoney, 3));
			
			String one = "1";
			System.out.println(one + " deleteEnd : " + MoneyComma.deleteEnd(one, 3));
		} catch (NotMoneyException e) {
			e.printStackTrace();
		} catch (NotValidNumberException e) {
			e.printStackTrace();
		}
	}
}
