package people;

import cargo.Nut;
import bird.Swallow;
import people.*;

/*  
 *  Falls Ihnen Teile der Aufgabe, Texte oder Variablenbenennungen komisch
 *  oder unlogisch erscheinen, sollten Sie den Film zu Erklaerung schauen.
 */

public class KingArthur {
  public static void main(String[] args) {
    System.out.println("King Arthur reitet in die Szene");
    Nut horse = new Nut();
    horse.setName("Kokosnuesse");
    horse.setWeight(7);
    System.out.println("Patsy imitiert ein Pferd und nutzt dazu " + horse.getName());
    System.out.println("Die " + horse.getName() + " wiegen " + horse.getWeight());

    System.out.println("Auf der Bruecke des Todes sitzt ein Troll.");
    Troll troll = new Troll();

    // Der folgende Code stellt dem Troll eine Frage, die der Troll aber beantworten
    // kann. Damit das Programm compiliert, wenn der Code nicht auskommentiert ist,
    // muessen Sie die eventuell auftretende Exception abfangen.
    //
    System.out.println("Was ist die Fluggeschwindigkeit dieser Kokusnuss?");
    try{
    System.out.println("Troll: " + troll.askAboutAirspeedVelocity("Unladden Swallow"));
    }
    catch(UnspecificQuestionException error){
      //error.printStackTrace();
    }
    
    System.out.println("Der Troll ist bestimmt harmlos, genau wie Kaninchen! Wir gehen einfach vorbei!");
    troll.pass();
    System.out.println("King Arthur hat den Troll sicher passiert!");
  }
}
