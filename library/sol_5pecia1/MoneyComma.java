package sol_5pecia1;

import java.util.regex.Pattern;

//TODO make exception, zero return, country const 
public class MoneyComma {
	private final static String COMMA = ",";
	private final static String DOT = ".";
	
	
	private MoneyComma(){
		
	}
	
	private static void checkMoney(String money){
		if(Pattern.matches("[0-9"+ COMMA +"]+(.[0-9]+)?", money)){
			
		}
	}
	
	private static void checkNumberLengthOne(String money){
		if(Pattern.matches("[0-9]", money)){
			
		}
	}
	
	public static String makePure(String money){
		checkMoney(money);
		return CutNAttachStringInterval.makePureString(money, COMMA);
	}
	
	public static String divide(String money, int divideUnit){
		checkMoney(money);
		String[] splitDot = money.split("[" + DOT + "]");
		String dividedMoney = CutNAttachStringInterval.makePureNDivideString(splitDot[0], COMMA, divideUnit); 
		return dividedMoney + ((splitDot.length == 2)? DOT + splitDot[1] : "");
	}
	
	public static String append(String money, int divideUnit, String appendNumber){
		checkMoney(money);
		checkNumberLengthOne(appendNumber);
		
		String reusultMoney = divide(money + appendNumber, divideUnit);
		return reusultMoney;
	}
	
	public static String deleteEnd(String money, int divideUnit){
		checkMoney(money);
		
		String[] splitDot = money.split("[" + DOT + "]");
		StringBuilder deletedMoney = new StringBuilder();
		if(splitDot.length == 2){
			deletedMoney.append(splitDot[0]);
			
			if(splitDot[1].length() > 1){
				String deleteEndNumber = splitDot[1].substring(0, splitDot[1].length() - 1);
				deletedMoney.append(DOT + deleteEndNumber);
			}
		} else{
			String pureNumber = makePure(splitDot[0]);
			
			if(pureNumber.length() > 1){
				String deleteEndNumber =  pureNumber.substring(0, pureNumber.length() - 1);
				deletedMoney.append(divide(deleteEndNumber, divideUnit));
			}
		}
		
		return deletedMoney.toString();
	}
}
