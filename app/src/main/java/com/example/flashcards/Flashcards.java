package com.example.flashcards;

public class Flashcards {
    private String Header;
    private String Description ;


    public Flashcards(String H , String D ) {
        this.Header = H;
        Description = D  ;
    }
    public String getHeader(){
        return Header;
    }
    public String getDescription() {return  Description ;}

}
