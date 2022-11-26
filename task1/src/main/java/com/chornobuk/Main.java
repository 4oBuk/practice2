package com.chornobuk;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    // main task:
    // parse xml file and split name and surname attributes
    // save formating in of the source file

    // subtasks
    // []1. create regex to get a person's block
    // []1.1. test regex (can replace regex with just searching for the end of a person block)
    // [x]2. create method to get name and surname from source tag (using xml parses)
    // [x]2.1. test method
    // []3. write method for parsing file
       // this method will read a person block per iteration in cycle send it to the method
       // for getting info and write in the result file
    // []3.1. test method
    // [x]4. create method for replacing surname and name properties with new name property
    // [x]4.1. test method
    // []6. naming and refactoring 

}
