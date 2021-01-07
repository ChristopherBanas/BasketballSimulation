package tests;

import model.Autogeneration.GeneratePlayer;
import org.junit.jupiter.api.Test;

class GeneratePlayerTest {

    @Test
    void GeneratePlayer(){
        GeneratePlayer generatePlayer = new GeneratePlayer();
        System.out.println(generatePlayer.generateName());
        System.out.println(generatePlayer.generateType());
        System.out.println(generatePlayer.generatePosition());
    }

}