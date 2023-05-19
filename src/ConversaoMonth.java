import java.time.Month;

public abstract class ConversaoMonth {
	public static Month convertido(String escolha) {
		switch (escolha) {
		case "1": {			
			return Month.JANUARY;
		}
		case "2":{
			return Month.FEBRUARY;
		}
		case "3":{
			return Month.MARCH;			
		}
		case "4": {			
			return Month.APRIL;
		}
		case "5":{
			return Month.MAY;
		}
		case "6":{
			return Month.JUNE;			
		}
		case "7": {			
			return Month.JULY;
		}
		case "8":{
			return Month.AUGUST;
		}
		case "9":{
			return Month.SEPTEMBER;			
		}
		case "10": {			
			return Month.OCTOBER;
		}
		case "11":{
			return Month.NOVEMBER;
		}
		case "12":{
			return Month.DECEMBER;
		
		}
		default:
			return null;
		}
	}
	
}
