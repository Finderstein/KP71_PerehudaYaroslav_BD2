package com.lab2;

import java.sql.ResultSet;
import java.sql.SQLException;

class View {
    void show_from_table_authors(ResultSet rs, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Authors");
        }
        try {
            while (rs.next()) {
                System.out.println("-----------------------------------");
                System.out.println("AuthorID: " + rs.getInt(1));
                System.out.println("AuthorName: " + rs.getString(2));
                System.out.println("CompletedBooks: " + rs.getString(3));
                System.out.println("Biography: " + rs.getString(4));
            }
            System.out.println("-----------------------------------");
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void show_from_table_books(ResultSet rs, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Books");
        }
        try {
            while (rs.next()) {
                System.out.println("-----------------------------------");
                System.out.println("BookID: " + rs.getInt(1));
                System.out.println("BookAuthor: " + rs.getInt(2));
                System.out.println("BookName: " + rs.getString(3));
                System.out.println("Genre: " + rs.getString(4));
                System.out.println("Year: " + rs.getString(5));
                System.out.println("Pages: " + rs.getInt(6));
            }
            System.out.println("-----------------------------------");
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void show_from_table_readers(ResultSet rs, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Readers");
        }
        try {
            while (rs.next()) {
                System.out.println("-----------------------------------");
                System.out.println("ReaderID: " + rs.getInt(1));
                System.out.println("ReaderName: " + rs.getString(2));
                System.out.println("PhoneNumber: " + rs.getString(3) );
                System.out.println("Address: " + rs.getString(4));
            }
            System.out.println("-----------------------------------");
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void show_from_table_reading(ResultSet rs, boolean showTitle)
    {
        if(showTitle) {
            System.out.println("-------------------------------------");
            System.out.println("TABLE Reading");
        }
        try {
            while (rs.next()) {
                System.out.println("-----------------------------------");
                System.out.println("ReadingID: " + rs.getInt(1));
                System.out.println("Reader: " + rs.getInt(2));
                System.out.println("Book: " + rs.getInt(3) );
                System.out.println("Started: " + rs.getString(4));
                System.out.println("Finished: " + rs.getString(5));
                System.out.println("ReadPages: " + rs.getInt(6));
            }
            System.out.println("-----------------------------------");
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void showMainMenu() {
        System.out.println("-+-+-+-+- Main Menu -+-+-+-+-");
        System.out.println("Choose table or operation: ");
        System.out.println("1) Table Authors");
        System.out.println("2) Table Books");
        System.out.println("3) Table Readers");
        System.out.println("4) Table Reading");
        System.out.println("5) Search from 2 tables");
        System.out.println("6) Text search");
        System.out.println("7) Generate random");
        System.out.println("8) Exit");
        System.out.print("-> ");
    }

    void showMenuTableOperations(String tableName){
        System.out.println("-+-+-+-+- Table " + tableName + " Menu -+-+-+-+-" );
        System.out.println("1) Read");
        System.out.println("2) Create");
        System.out.println("3) Update");
        System.out.println("4) Delete");
        System.out.println("5) To Main Menu");

        System.out.print("-> ");
    }

    void showSearchFrom2Tables(ResultSet rs){
        try{
            while(rs.next()){
                System.out.println("-----------------------------------");
                System.out.println("AuthorID: " + rs.getInt(1));
                System.out.println("AuthorName: " + rs.getString(2));
                System.out.println("DateOfBirth: " + rs.getString(3));
                System.out.println("Biography: " + rs.getString(4));
                System.out.println("BookID: " + rs.getInt(5));
                System.out.println("BookAuthor: " + rs.getInt(6));
                System.out.println("BookName: " + rs.getString(7));
                System.out.println("Genre: " + rs.getString(8));
                System.out.println("Year: " + rs.getString(9) );
                System.out.println("Pages: " + rs.getInt(10));
            }
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void showUpdateMenu1(){
        System.out.println("This data doesn't exist");
        System.out.println("1) Stop operation");
        System.out.println("Anything else) Try again");
        System.out.print("-> ");
    }

    void showUpdateMenu2(){
        System.out.println("1) Update");
        System.out.println("2) Stop operation");
        System.out.println("Anything else) Choose another");
        System.out.print("-> ");
    }

    void showDeleteMenu1(){
        System.out.println("This data doesn't exist");
        System.out.println("1) Stop operation");
        System.out.println("Anything else - Try again");
        System.out.print("-> ");
    }

    void showDeleteMenu2(){
        System.out.println("1) Delete");
        System.out.println("2) Stop operation");
        System.out.println("Anything else - Choose another");
        System.out.print("-> ");
    }

    void showFullTextSearchMenu() {
        System.out.println("1) Word is not included from table Books field BookName");
        System.out.println("2) Phrase search from table Books field BookName");
        System.out.println("3) To main menu");
        System.out.print("-> ");
    }

    void showTextSearchResult(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println("-----------------------------------");
                System.out.println("BookID: " + rs.getInt(1));
                System.out.println("BookAuthor: " + rs.getInt(2));
                System.out.println("BookName: " + rs.getString(3));
                System.out.println("Genre: " + rs.getString(4));
                System.out.println("Year: " + rs.getString(5));
                System.out.println("Pages: " + rs.getInt(6));
            }
            System.out.println("-----------------------------------");
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }
}

