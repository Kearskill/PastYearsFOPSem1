package paper2024;

public class Q2c {
    public static void main(String[] args) {
        Playable[] playable = {new Guitar(), new Piano()};
        for (Playable k : playable){
            k.play();
        }
    }
}
/*Create a Java program demonstrating polymorphism using an interface. Define an interface
* Playable with the method play(). Create two classes Guitar and Piano that implement this interface. In
* your main method, create an array of Playable objects and initialize it with Guitar and
* Piano instances. Iterate through the array and invoke the play() method on each object*/

interface Playable{
    void play();
}
class Guitar implements Playable{
    @Override
    public void play(){
        System.out.println("Playing the Guitar!");
    }
}

class Piano implements Playable{
    @Override
    public void play(){
        System.out.println("Playing the Piano!");
    }
}