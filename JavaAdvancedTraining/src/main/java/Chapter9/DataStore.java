package Chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class DataStore {

    static List<Integer> randomNumbers(){
        Random rnd = new Random();
        List<Integer> numbers = new ArrayList<>();
        int count = rnd.nextInt(3, 20);


        for(int i = 0; i < count; i++){

            numbers.add(rnd.nextInt(210,350));
        }

        return numbers;
    }

    static Stream<String> cities(){
        return  Stream.of("Midrand","Pretoria","Centurion", "Rustenburg","Sandton");
    }
}
