package metier;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

public class Calculateur {		
public static final String UNITEtemps="minute";//possible minute ou seconde 
//****************************************************************************************************************************************
 //CALCULER  difference du  temps STOP-START en utilisant des STRING comme parametres et en retournant un DOUBLE 
 double calculStringDif(String sstop, String sstart){
	 double tr=0;
	 long stop = Long.parseLong(sstop);
	 long start=Long.parseLong(sstart);
	 tr=calculUnixDif(stop,start,UNITEtemps);
	 return tr;
 }
//****************************************************************************************************************************************
//VERSION  ARRETFIX: 21/07/2016 CALCULER  la difference UNIX DIRECTEMENT  à format DOUBLE à partir d'un seule  temps STRING UNIX OK 
 double calculStringDirectDif(String sTotal){
	 double dif=0;
	 long total=Long.parseLong(sTotal);//conversion du temps total String à long UNIX 
	 dif=this.formaterUnixDouble(total, UNITEtemps);//convert UNIX temps a SECONDE double
	 return dif;
 }
//****************************************************************************************************************************************
 //CALCULER  le TEMPS TNET en double et enregistrement sur Bean //Unité du temps par defaut= UNITEtemps OK
 public  double calculTnet(int nb , int nr ,String ref ,double tc ){
	 double tnet=0;
	 tnet=(nb+nr)*tc;
	 tnet=Math.round(tnet*10000.0)/10000.0;
	 return tnet;
 }
//****************************************************************************************************************************************
//CALCULER le temps TU en double et enregistrement sur Bean OK
 public  double calculTu(int nb,String ref ,double tc ){
	 double tu=0;
	 tu=(nb)*tc;
	 tu=Math.round(tu*10000.0)/10000.0;
	 return tu;
 }
 //***************************************************************************************************************************************
 //CALCULER la DIFFERENCE  entre deux timestamps UNIX  et retourne en MINUTES ou SECONDES double OK  
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
 //***************************************************************************************************************************************
 //FORMATER TEMPS UNIX DE FORMAT LONG à DOUBLE en SECONDS ou MINUTES OK 
 double formaterUnixDouble(long unixtime,String type){
	 double dif=unixtime;
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
 //***************************************************************************************************************************************
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
//****************************************************************************************************************************************
 //SEPARER separere des String provenanat du requet  Multiple en 1 tableau de 2 String REF et TC
 public String [] separerString(String parametre) throws Exception{
	 String [] valeurs= parametre.split("-");
	 if(valeurs.length==2){	 
	 }else{
		 throw new Exception("le string  tableau a une taille different  a 2 ")  ;
	 }return valeurs;
 	}	
//****************************************************************************************************************************************
//OBTENIR Parametre en format String provenanant de la requete Http
 public String obtenirParam( HttpServletRequest request, String nomChamp ) {
    String valeur = request.getParameter( nomChamp );
    if ( valeur == null || valeur.trim().length() == 0 ) {
        return null;
    } else {
        return valeur.trim();}
	}
}

