package com.crio.qcalc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class StandardCalculatorTest {
    private StandardCalculator standardCalculator;
    private double result;
   

    @BeforeEach
    void setup(){
        standardCalculator = new StandardCalculator();
    }


    public void add(double num1, double num2){

        double result = num1 + num2;
    
        if((result == Double.MAX_VALUE) || (result == Double.POSITIVE_INFINITY)){
    
            throw new ArithmeticException("Double overflow");
    
        }
    
        this.result = result;
    
    }
    

    
@Test

@DisplayName("Test Addition Overflow of Two Doubles")

void testAdditionOverflowForDoubles(){

    //Assert

    Assertions.assertThrows(ArithmeticException.class,new Executable(){

        @Override

        public void execute() throws Throwable{

            standardCalculator.add(Double.MAX_VALUE, Double.MAX_VALUE);

        }

    });

}


@Test

@DisplayName("Test Subtraction Overflow of Two Doubles")

void testSubtractionOverflowForDoubles(){

    //Assert

    Assertions.assertThrows(ArithmeticException.class,new Executable(){

    @Override

    public void execute() throws Throwable{

            standardCalculator.subtract(-Double.MAX_VALUE,Double.MAX_VALUE);

        }

    });

}



    @Test
    @DisplayName("Test Multiplicationof Two Doubles")
    void testMultiplicationOperationForDoubles(){
        standardCalculator.multiply(2.0,4.0);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(8.0, actualResult);
    }

    
   @Test

   @DisplayName("Test Division Divide By Zero Scenario")

   void testDivisionDivideByZero(){

       //Assert

       Assertions.assertThrows(ArithmeticException.class,new Executable(){

           @Override

           public void execute() throws Throwable{

               standardCalculator.divide(10,0);

           }

       });

   }




}
