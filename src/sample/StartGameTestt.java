package sample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class StartGameTestt {

    @Test
    public void test(){
        boolean tak = true;
        if(tak){
            tak = false;
        }
        Assertions.assertEquals(false, false);
    }

    @Test
    public void test1(){
        boolean tak = true;
        if(tak){
            tak = false;
            ///buttoniki
        }
        Assertions.assertEquals(false, false);
    }

}