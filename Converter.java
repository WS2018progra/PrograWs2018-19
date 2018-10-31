public class Converter {


    public static void main(String [] args){
    
        String userInput=SimpleIO.getString("Bitte waehlen sie aus:\nDecimal: Dezimalzahl ins Zweierkomplement konvertieren.\nBinary: 8-Bit-Zweierkomplement als Dezimalzahl darstellen.");
        if(userInput.equals("Decimal")){
            boolean continue_=false;
            int userIntInput=0;
            //nimmt den Userinput und überprüft ob dieser im Zahlenbereich liegt, fall nicht muss der nutzer diese erneut eingeben
            while(!continue_){
                userIntInput = SimpleIO.getInt("Bitte geben sie eine Dezimalzahl zwischen -128 und 127 ein");
                if(userIntInput>-129 && userIntInput<128){
                    continue_=true;
                }
            }
            String binary = convertDezToBin(userIntInput);
            SimpleIO.output(binary,"Ihre Zahl im 2er Komplement dargestellt ist");
        }

        else if(userInput.equals("Binary")){
            boolean continue__=false;
            String userBinaryInput="";

            while(!continue__){
                userBinaryInput = SimpleIO.getString("Bitte geben sie eine Binaere Zahl ein (nur 0er und 1er) die 8 stellen lang ist");
                if(userBinaryInput.length()==8 && isUserInputLegal(userBinaryInput)){
                    continue__=true;
                }
            }
            int output=0;
            if(userBinaryInput.charAt(0)=='1'){
                String komplement=komplementOf(userBinaryInput);
                output=getValueOfBinary(komplement);
                output=-output;
            }
            else output=getValueOfBinary(userBinaryInput);

            SimpleIO.output("Ihre Zahl betraegt: "+output,"Ergebins");
        }
        else SimpleIO.output("Bitte geben sie eine zulaessige Eingabe ein","Error");
    }

    public static boolean isUserInputLegal(String userInput){
        
        boolean legal=true;

        for(int i=0;i<8;i++){
            if(userInput.charAt(i)!='0'&&userInput.charAt(i)!='1'){
            legal=false;
            break;
            }
        }
        return legal;
    }

    public static String convertDezToBin(int userInput){
        String output="",inverseOutput="";
        for(int i=0;i<8;i++){
            if(userInput%2==0){
                inverseOutput+='0';
                userInput/=2;
            }
            else{
                inverseOutput+='1';
                userInput=(userInput-1)/2;
            } 
        }
        //the number obtained must be turned around
        for(int x=7;x>-1;x--){
            output+=inverseOutput.charAt(x);
        }
        return output;
    }

    public static String inverseBinary(String binaryInput){
        String output="";
        for(int i=0;i<8;i++){
            if(binaryInput.charAt(i)=='0'){
                output+='1';
            }
            else output+='0';
        }
        return output;
    }

    public static int getValueOfBinary(String binaryInput){
        int output=0;
        for(int i=0;i<8;i++){
            if(binaryInput.charAt(i)=='1'){
                output+=zweiHoch(7-i);
            }
        }
        return output;
    }

    public static int zweiHoch(int exponent){
        int output=1;
        for(int i=0;i<exponent;i++){
            output*=2;
        }
        return output;
    }

    public static String addOne(String binary){
        String output="";
        boolean overflow=true;
        char[] charArray=new char[8];
        //7-i da er sonst rückwärts im array gehen würde
        for(int i=0;i<8;i++){
            if(binary.charAt(7-i)=='0'){
                if(overflow){
                    charArray[7-i]='1';
                    overflow=false;
                }
                else{
                     charArray[7-i]='0';
                }
            }
            else{
                if(overflow){
                    charArray[7-i]='0';
                    overflow=true;
                }
                else{
                    charArray[7-i]='1';
                }
            }
        }
        for(int x=0;x<8;x++)output+=charArray[x];
        return output;
    }

    public static String komplementOf(String input){
        String inverse=inverseBinary(input);
        String output=addOne(inverse);
        return output;
    }
}