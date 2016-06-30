package metier;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

public class Calculateur {
		
public static final String UNITEtemps="minute";//possible minute ou seconde 
//**************************************************************************************************************************************
 //Calcul le temps TR en double  et enregistrement sur Bean OK
 double calculTr(long stop, long start){
	 double tr=0;
	 tr=calculUnixDif(stop,start,UNITEtemps);
	 return tr;
 }
 //Calcul le temps ARRET1 en double et enregistrment sur Bean OK
 double calculArret1(long stop, long start){
	 double arret1=0;
	 arret1=calculUnixDif(stop,start,UNITEtemps);
	 return arret1;
 }
 //Calcul le temps ARRET2en double et enregistrment sur Bean OK
 double calculArret2(long stop, long start){
	 double arret2=0;
	 arret2=calculUnixDif(stop,start,UNITEtemps);
	 return arret2;
 }
 //Calcul le temps TNET en double et enregistrement sur Bean //Unité du temps par defaut= UNITEtemps OK
 public double  calculTnet(int nb , int nr ,  String ref){
	 double tc =getTC(UNITEtemps,ref);
	 double tnet=(nb+nr)*tc;	
	 tnet=Math.round(tnet*10000.0)/10000.0;
	 return tnet;
 }
 //Calcul le temps TU en double et enregistrment sur Bean OK
 public  double  calculTu(int nb,String ref){
	 double tc =getTC(UNITEtemps,ref);
	 double tu=nb*tc;	
	 tu=Math.round(tu*10000.0)/10000.0;
	 return tu;
 }
 //***********************************************************************************************************************************
 //pour choisir le TC a utiliser pour calculer les valeurs tu ET tnet selon le parametre reference  la requete  HTTP OK à MODIFIER POUR SECONDS  MINUTES ET HEURES PAR BOBINEUSE  OK
double getTC(String type,String ref ){
	TempsCycle tcObj=TempsCycle.getTcObjet();
	double tc=0;
	if(type.equalsIgnoreCase("seconde")){
		tc=tcObj.getMachine1().get(0).get(ref);	
	}else if(type.equalsIgnoreCase("minute")){
		tc=tcObj.getMachine1().get(1).get(ref);	
	}else if(type.equalsIgnoreCase("heure")){
		tc=tcObj.getMachine1().get(2).get(ref);	
	}else{
		new IllegalArgumentException("Variable Type TempsCycle Invalid " +type);
	}
	return tc;
	}	
 //**************************************************************************************************************************************
 //Calcul de DIFFERENCE  entre deux timestamps UNIX  et retourne en MINUTES ou SECONDES double OK
 double calculUnixDif(long  stop , long start ,String type){
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
 //*************************************************************************************************************************************
 //FORMATAGE  de timestamps UNIX en DATETIME SQL String OK
 String formaterUnixTime(long unixtime){
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
