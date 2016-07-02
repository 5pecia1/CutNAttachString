package sol_5pecia1;

public class DivideStringInterval {

	private DivideStringInterval(){
		
	}
	
	public static String makePureString(String purposeString, String dividingString){
		return purposeString.replace(dividingString, "");
	}
	
	public static String divideStringInterval(String purposeString, String dividingString, int dividingInterval){
		int pureStringLength = purposeString.length();
		StringBuilder resultString = new StringBuilder();
		
		if(pureStringLength > dividingInterval){
			int stringHeadLength = pureStringLength % dividingInterval;
			int insertingCount = pureStringLength / dividingInterval - 1;
			
			if(stringHeadLength  != 0){
				String head = purposeString.substring(0, stringHeadLength);
				String tail = purposeString.substring(stringHeadLength);
				resultString.append(head + dividingString);
				purposeString = tail;
			}
			
			int i = 0;
			for(;i < insertingCount; i++){
				String head = purposeString.substring(i * dividingInterval, i * dividingInterval + dividingInterval);
				resultString.append(head + dividingString);
			}
			
			String last = purposeString.substring(i * dividingInterval);
			resultString.append(last);
			
		} else{
			resultString.append(purposeString);
		}
		
		return resultString.toString();
	}
	
	public static String makePureNDivideStringInterval(String purposeString, String dividingString, int dividingInterval){
		String pureString = makePureString(purposeString, dividingString);
		return divideStringInterval(pureString, dividingString, dividingInterval);
	}
	
}
