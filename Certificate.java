import java.util.Random;

/**
 * Klasse zum Erstellen von Certificates
 * @author Mika Rosin,Max
 */
public class Certificate{

    private Algorithm algorithm;
    private Pair[] pair;
    private String signature=null;

    //Diese Variablen ist nur für die Zusatzaufgabe
    private long birthTime;
    private Random rand;
    
    Certificate(Algorithm alg,Pair ...pair){
        birthTime=System.currentTimeMillis();
        rand=new Random(birthTime);
        algorithm=alg;
        this.pair=new Pair[pair.length];
        for(int i=0;i<pair.length;i++){
            this.pair[i]=pair[i];
        }
    }

    /**
     * Gibt den Wert zu einem Passenden Schlüssel zurück
     * @param key Schlüssel (key) für den man einen gespeicherten Wert möchte
     * @return Wert (value) der zu dem Schlüssel gehört
     */
    public String get(String key){
        for(int i=0;i<pair.length;i++){
            if(pair[i].getKey().equals(key)){
                return pair[i].getValue();
            }
        }
        return null;
    }

    /**
     * Erstellt ein Certificate aus einem String
     *@param input der Inputstring der den ENBF regeln für ein Certificate folgen muss und ausdem das Certificate erstellt wird
     * @return Certificate das aus dem Inputstring erstellt wurde
     */
    public static Certificate fromString(String input){
        Algorithm alg;Pair[] pair;Signature sign;
        String[] temp=input.split(";");
        String Header=temp[0];
        String Body=temp[1];
        String signature=temp[2];

        if(Header.equals("HMAC_MD5")){
            alg=Algorithm.HMAC_MD5;
        }
        else if(Header.equals("HMAC_SHA1")){
            alg=Algorithm.HMAC_SHA1;
        }
        else if(Header.equals("HMAC_SHA256")){
            alg=Algorithm.HMAC_SHA256;
        }
        else{
            System.out.println("Error wrong input for Header");
            alg=null;
        }

        String[] tmp=Body.split(",");
        pair=new Pair[tmp.length];
        for(int i=0;i<tmp.length;i++){
            pair[i]=Pair.fromString(tmp[i]);
        }

        Certificate c1 = new Certificate(alg, pair);
        c1.signature=signature;
        return c1;
    }

    /**
     * Methode um eine Signatur aus einem String zu erstellen
     * @param secret ein Secret das zum Erstellen einer Signatur genutzt wird
     * @return Signatur des Secrets
     */
    public String getSignedString(String secret){
      if(signature!=null){} 
      else signature=calculateHash(secret);
      return getHeaderBodyString()+signature;
    }

    /**
     * Methode die einen Hash aus einem String berechnet
     * @param secret String aus dem der Hash berechnet wird
     * @return einen Hash (Signatur) in form eines Strings
     */
    private String calculateHash(String secret){
        String signature;
        if(algorithm==Algorithm.HMAC_MD5){
            signature=Hasher.byteArrayToHex(Hasher.md5Hmac(getHeaderBodyString(), secret));
        }
        else if(algorithm==Algorithm.HMAC_SHA1){
            signature=Hasher.byteArrayToHex(Hasher.sha1Hmac(getHeaderBodyString(), secret));
        }
        else if(algorithm==Algorithm.HMAC_SHA256){
            signature=Hasher.byteArrayToHex(Hasher.sha256Hmac(getHeaderBodyString(), secret));
        }
        else{System.out.println("Error no algorithm set");return null;}
        return signature;
    }

    private String getHeaderBodyString(){
     String output=null;
     if(algorithm==Algorithm.HMAC_MD5){
         output="HMAC_MD5;";
     }
     else if(algorithm==Algorithm.HMAC_SHA1){
         output="HMAC_SHA1;";
     }
     else if(algorithm==Algorithm.HMAC_SHA256){
         output="HMAC_SHA256;";
     }
     else {
         System.out.println("Error no Algorithm set");
         return null;
     }
     for(int i=0;i<pair.length;i++){
        output+= "'"+pair[i].getKey()+"': '"+pair[i].getValue()+"'";
        if(i==pair.length-1){
            output+=";";
        }
        else output+=",";
     }
     return output;
    }
    
    /**
     * Diese Methode überprüft die Richtigkeit einer Signatur
     * @param secret Eingabe Parameter aus dem die Signatur berechnet wird
     * @return True oder false je nach dem ob die Signatur richtig oder falsch ist
     */
    public boolean validateSignature(String secret){
        /*um die Laufzeit zu Verschleiern wird jedesmal ein weiteres Wort
          überprüft, da das Wort "zufällig" ausgesucht wird
          kann der Angreifer nicht wissen um wieviel die Laufzeit verlängert wird. Selbst wenn er die Wörter
          kennen würde müsste er die exakte Zeit in millisekunden wissen in der das Certificate erstellt wurde
          (den seed). Prinzipiell müsste das eine Attacke bezogen auf die Laufzeit verhindern.
        */
        //die Wörter die ausgewählt werden
        String arrayString[]={"next","please","Das","hier","ist","bestimmt","richtig","(ist es nicht aber kann ich tortzdem Bonuspunkte haben bitte?"};
        //n wird durchegehend irgendeinem Wert >=0 und <8 zugewiesen
        int n = rand.nextInt(8)+0;
        //die Signatur des Wortes an der Stelle n im arrayString wird berechnet um die Laufzeit zu verändern
        signature.equals(arrayString[n]);
        if(signature.equals(calculateHash(secret))){
            return true;
        }
        else{
            return false;
        }
    }

}
