package sol_5pecia1;

public class CutNAttachStringInterval {

	private CutNAttachStringInterval(){
		
	}
	
	public static String makePureString(String purposeString, String dividingString){
		return purposeString.replace(dividingString, "");
	}
	
	public static String divideString(String purposeString, String dividingString, int dividingInterval){
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
	
	public static String makePureNDivideString(String purposeString, String dividingString, int dividingInterval){
		String pureString = makePureString(purposeString, dividingString);
		return divideString(pureString, dividingString, dividingInterval);
	}
	
	public static String append(String purposeString, String dividingString, int dividingInterval, String appendString){
		return makePureNDivideString(purposeString + appendString, dividingString, dividingInterval);
	}
	
	public static String deleteEnd(String purposeString, String dividingString, int dividingInterval){
		String pureString = makePureString(purposeString, dividingString);
		return divideString(pureString.substring(0, pureString.length() - 1), dividingString, dividingInterval);
	}
}
