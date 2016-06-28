package metier;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class timeTest {

	


	public static void main(String[] args) {
		BeanMetier bean2= new BeanMetier();
		LocalDateTime LDTstart;
		LocalDateTime LDTstop;
		LocalDate LDstart;
		LocalDate LDstop;
		
		long ecartLDT;
		long startUnix;
		long stopUnix;
		double ecartUnix;
		long directUnix =1467122375065L;
		
	
		
		LDTstart=LocalDateTime.now();
		startUnix=System.currentTimeMillis();//temps Debut  en format Unix 
		
		/**Conversion de UnixTime Milliseconds to 2014        'YYYY-MM-DD HH:MM:SS' format SQL accepté */
		
		Instant timestamp=Instant.ofEpochMilli(directUnix);
		LocalDateTime datetime1 =LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
				//LocalDateTime.ofEpochSecond(epochSecond, nanoOfSecond, offset)
		
		//Formatage de date selon le type DATETIME SQL 
		DateTimeFormatter format=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		
		String datetime2=datetime1.format(format);
		
		 try {
			Thread.sleep(3137);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 LDTstop=LocalDateTime.now(); 
		stopUnix=System.currentTimeMillis();//temps Stop en format Unix 
		 
		
		
		 bean2.setStartDT(LDTstart);
		 bean2.setStopDT(LDTstop);
		 System.out.println("la LocalDateTime LDTstart vaut " + LDTstart);
		 System.out.println("la UNIXTime start vaut " + startUnix);
		 
		  System.out.println("*************************************************************");
		 System.out.println("la LocalDateTime LDTstop vaut " + LDTstop);
		 System.out.println("la UNIXTime stop vaut " + stopUnix);
		  System.out.println("*************************************************************");
		 
		 ecartLDT = ChronoUnit.SECONDS.between(bean2.getStartDT(), bean2.getStopDT());
	
		 ecartUnix=unixDif(stopUnix,startUnix,"minute");
		  System.out.println("l'ecart entre  LDTstart et LDTstop vaut " + ecartLDT);
		  System.out.println("l'ecart entre  startUnix et stopUnix vaut " + ecartUnix);
		  System.out.println("*************************************************************");
		  System.out.println("Conversion UNIX start Time =" + datetime1);
		  System.out.println("Conversion UNIX start Time =" + datetime2);
		  System.out.println("****************************StopUnix Temps avec Methode*********************************");
		  System.out.println("Conversion UNIX start Time = " + formatUnixTime(stopUnix));
	}

	
	/*public static double unixDif(long start,long stop ){
		long dif=start-stop;
		double result=dif/1000;
		return result;
	}*/
	public static double unixDif(long stop,long start,String type){
		double dif=stop-start;
		double result;
		if(type.equals("seconde")){
			result=dif/1000;
			result=Math.round(result*10000.0)/10000.0;
		}else if(type.equals("minute")){
			result=dif/60000;
			result=Math.round(result*10000.0)/10000.0;
		}else{
			result=dif;
		}
		return result;
	}


public static String formatUnixTime(long unixtime){
	Instant timestamp;
	LocalDateTime datetime1;
	DateTimeFormatter format;
	String  datetime2;
	
	//Convertir Unix milliseconds à Instant Object
	timestamp=Instant.ofEpochMilli(unixtime);
	//Convertir Instant Object à LocalDateTime avec Default TimeZone
	datetime1 =LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
	//Formatage de date selon le type DATETIME SQL YYYY-MM-dd HH:mm:ss 
	format=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
	//Conversion de LocalDateTime  à String Final 
	datetime2=datetime1.format(format);
	return datetime2;
}
}
