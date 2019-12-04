package com.lab2;

import java.sql.*;

class Model {
    private Connection dbConnection;

    void make_connection() {
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/Lab1";
            dbConnection = DriverManager.getConnection(URL,"postgres","master132000");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Connection has been successfully created!");
    }

    void insert_in_table_authors(String name, String dateOfBirth, String biography) {
        try {
            String sqlInsert = "INSERT INTO \"Authors\" (\"AuthorName\", \"DateOfBirth\", \"Biography\") "
                    + "VALUES (?, ?, ?)";
            PreparedStatement prpInsertStmt = dbConnection.prepareStatement(sqlInsert);
            prpInsertStmt.setString(1, name);
            prpInsertStmt.setString(2, dateOfBirth);
            prpInsertStmt.setString(3, biography);
            prpInsertStmt.executeUpdate();
            System.out.println("Insertion has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void insert_in_table_books(int authorId, String name, String genre, String year, int pages) {
        try {
            String sqlInsert = "INSERT INTO \"Books\" (\"BookAuthor\", \"BookName\", \"Genre\", \"Year\", \"Pages\") "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prpInsertStmt = dbConnection.prepareStatement(sqlInsert);
            prpInsertStmt.setInt(1, authorId);
            prpInsertStmt.setString(2, name);
            prpInsertStmt.setString(3, genre);
            prpInsertStmt.setString(4, year);
            prpInsertStmt.setInt(5, pages);
            prpInsertStmt.executeUpdate();
            System.out.println("Insertion has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void insert_in_table_readers(String name, String phone, String address) {
        try {
            String sqlInsert = "INSERT INTO \"Readers\" (\"ReaderName\", \"PhoneNumber\", \"Address\") "
                    + "VALUES (?, ?, ?)";
            PreparedStatement prpInsertStmt = dbConnection.prepareStatement(sqlInsert);
            prpInsertStmt.setString(1, name);
            prpInsertStmt.setString(2, phone);
            prpInsertStmt.setString(3, address);
            prpInsertStmt.executeUpdate();
            System.out.println("Insertion has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void insert_in_table_reading(int reader, int book, String started, String finished, int readPages) {
        try {
            String sqlInsert = "INSERT INTO \"Reading\" (\"Reader\", \"Book\", \"Started\", \"Finished\", \"ReadPages\") "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prpInsertStmt = dbConnection.prepareStatement(sqlInsert);
            prpInsertStmt.setInt(1, reader);
            prpInsertStmt.setInt(2, book);
            prpInsertStmt.setString(3, started);
            prpInsertStmt.setString(4, finished);
            prpInsertStmt.setInt(5, readPages);
            prpInsertStmt.executeUpdate();
            System.out.println("Insertion has been successfully done!");
        }
        catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    ResultSet select_all_from_table_authors() {
        ResultSet rs = null;
        try {
            String sqlSelectAll = "SELECT * FROM \"Authors\"";
            Statement statement = dbConnection.createStatement();
            rs = statement.executeQuery(sqlSelectAll);
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_all_from_table_books() {
        ResultSet rs = null;
        try {
            String sqlSelectAll = "SELECT * FROM \"Books\"";
            Statement statement = dbConnection.createStatement();
            rs = statement.executeQuery(sqlSelectAll);
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_all_from_table_readers() {
        ResultSet rs = null;
        try {
            String sqlSelectAll = "SELECT * FROM \"Readers\"";
            Statement statement = dbConnection.createStatement();
            rs = statement.executeQuery(sqlSelectAll);
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_all_from_table_reading() {
        ResultSet rs = null;
        try {
            String sqlSelectAll = "SELECT * FROM \"Reading\"";
            Statement statement = dbConnection.createStatement();
            rs = statement.executeQuery(sqlSelectAll);
        }catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_by_id_from_table_authors(int authorId) {
        ResultSet rs = null;
        try {
            String select = "SELECT * FROM \"Authors\" WHERE \"AuthorID\" = ?";
            PreparedStatement prpSelectStmt = dbConnection.prepareStatement(select);
            prpSelectStmt.setInt(1, authorId);
            rs = prpSelectStmt.executeQuery();
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_by_id_from_table_books(int bookId) {
        ResultSet rs = null;
        try{
            String select = "SELECT * FROM \"Books\" WHERE \"BookID\" = ?";
            PreparedStatement prpSelectStmt = dbConnection.prepareStatement(select);
            prpSelectStmt.setInt(1, bookId);
            rs = prpSelectStmt.executeQuery();
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_by_id_from_table_readers(int readerId) {
        ResultSet rs = null;
        try{
            String select = "SELECT * FROM \"Readers\" WHERE \"ReaderID\" = ?";
            PreparedStatement prpSelectStmt = dbConnection.prepareStatement(select);
            prpSelectStmt.setInt(1, readerId);
            rs = prpSelectStmt.executeQuery();
        }
        catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    ResultSet select_by_id_from_table_reading(int readingId) {
        ResultSet rs = null;
        try{
            String select = "SELECT * FROM \"Reading\" WHERE \"ReadingID\" = ?";
            PreparedStatement prpSelectStmt = dbConnection.prepareStatement(select);
            prpSelectStmt.setInt(1, readingId);
            rs = prpSelectStmt.executeQuery();
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return rs;
    }

    void update_in_table_authors(int authorId, String name, String dateOfBirth, String bio) {
        try {
            String sqlUpdate = "UPDATE \"Authors\" SET \"AuthorName\" = ?, \"DateOfBirth\" = ?, \"Biography\" = ? WHERE \"AuthorID\" = ?";
            PreparedStatement prpUpdateStmt = dbConnection.prepareStatement(sqlUpdate);
            prpUpdateStmt.setString(1, name);
            prpUpdateStmt.setString(2, dateOfBirth);
            prpUpdateStmt.setString(3, bio);
            prpUpdateStmt.setInt(4, authorId);
            prpUpdateStmt.executeUpdate();
            System.out.println("Update of Author with ID " + authorId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void update_in_table_books(int bookId, int authorId, String name, String genre, String year, int pages) {
        try {
            String sqlUpdate = "UPDATE \"Books\" SET \"BookAuthor\" = ?, \"BookName\" = ?, \"Genre\" = ?, \"Year\" = ?, \"Pages\" = ? WHERE \"BookID\" = ?";
            PreparedStatement prpUpdateStmt = dbConnection.prepareStatement(sqlUpdate);
            prpUpdateStmt.setInt(1, authorId);
            prpUpdateStmt.setString(2, name);
            prpUpdateStmt.setString(3, genre);
            prpUpdateStmt.setString(4, year);
            prpUpdateStmt.setInt(5, pages);
            prpUpdateStmt.setInt(6, bookId);
            prpUpdateStmt.executeUpdate();
            System.out.println("Update of Book with ID " + bookId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void update_in_table_readers(int readerId, String name, String phone, String address) {
        try {
            String sqlUpdate = "UPDATE \"Readers\" SET \"ReaderName\" = ?, \"PhoneNumber\" = ?, \"Address\" = ? WHERE \"ReaderID\" = ?";
            PreparedStatement prpUpdateStmt = dbConnection.prepareStatement(sqlUpdate);
            prpUpdateStmt.setString(1, name);
            prpUpdateStmt.setString(2, phone);
            prpUpdateStmt.setString(3, address);
            prpUpdateStmt.setInt(4, readerId);
            prpUpdateStmt.executeUpdate();
            System.out.println("Update of Reader with ID " + readerId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void update_in_table_reading(int readingId, int reader, int book, String started, String finished, int readPages) {
        try {
            String sqlUpdate = "UPDATE \"Reading\" SET \"Reader\" = ?, \"Book\" = ?, \"Started\" = ?, \"Finished\" = ?, \"ReadPages\" = ? WHERE \"ReadingID\" = ?";
            PreparedStatement prpUpdateStmt = dbConnection.prepareStatement(sqlUpdate);
            prpUpdateStmt.setInt(1, reader);
            prpUpdateStmt.setInt(2, book);
            prpUpdateStmt.setString(3, started);
            prpUpdateStmt.setString(4, finished);
            prpUpdateStmt.setInt(5, readPages);
            prpUpdateStmt.setInt(6, readingId);
            prpUpdateStmt.executeUpdate();
            System.out.println("Update of Reading with ID " + readingId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void delete_from_table_authors(int authorId) {
        try {
            String sqlDelete = "DELETE FROM \"Authors\" WHERE \"AuthorID\" = ?";
            PreparedStatement prpDeleteStmt = dbConnection.prepareStatement(sqlDelete);
            prpDeleteStmt.setInt(1, authorId);
            prpDeleteStmt.executeUpdate();
            System.out.println("Delete of Author with ID " + authorId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void delete_from_table_books(int bookId) {
        try {
            String sqlDelete = "DELETE FROM \"Books\" WHERE \"BookID\" = ?";
            PreparedStatement prpDeleteStmt = dbConnection.prepareStatement(sqlDelete);
            prpDeleteStmt.setInt(1, bookId);
            prpDeleteStmt.executeUpdate();
            System.out.println("Delete of Book with ID " + bookId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void delete_from_table_readers(int readerId) {
        try {
            String sqlDelete = "DELETE FROM \"Readers\" WHERE \"ReaderID\" = ?";
            PreparedStatement prpDeleteStmt = dbConnection.prepareStatement(sqlDelete);
            prpDeleteStmt.setInt(1, readerId);
            prpDeleteStmt.executeUpdate();
            System.out.println("Delete of Reader with ID " + readerId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    void delete_from_table_reading(int readingId){
        try {
            String sqlDelete = "DELETE FROM \"Reading\" WHERE \"ReadingID\" = ?";
            PreparedStatement prpDeleteStmt = dbConnection.prepareStatement(sqlDelete);
            prpDeleteStmt.setInt(1, readingId);
            prpDeleteStmt.executeUpdate();
            System.out.println("Delete of Reading with ID " + readingId + " has been successfully done!");
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
    }

    ResultSet search_from_2_tables(String name, int from, int to) {
        ResultSet rs = null;
        try{
            String sqlSearch = "SELECT * FROM \"Authors\" INNER JOIN \"Books\" on \"Authors\".\"AuthorID\" = \"Books\".\"BookAuthor\""
                    + " WHERE (\"Pages\" between ? and ? ) and \"AuthorName\" = ?";
            PreparedStatement prpSearchStmt = dbConnection.prepareStatement(sqlSearch);
            prpSearchStmt.setInt(1, from);
            prpSearchStmt.setInt(2, to);
            prpSearchStmt.setString(3, name);
            rs = prpSearchStmt.executeQuery();
        } catch (SQLException sql_except){
            sql_except.printStackTrace();
        }
        return  rs;
    }

    ResultSet noWordSearch(String word) {
        ResultSet rs = null;
        try{
            String sqlWordSearch = "SELECT * FROM \"Books\" WHERE NOT to_tsvector(\"BookName\") @@ to_tsquery(?)";
            PreparedStatement prpSearchStmt = dbConnection.prepareStatement(sqlWordSearch);
            prpSearchStmt.setString(1 , word);
            rs = prpSearchStmt.executeQuery();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return  rs;
    }

    ResultSet phraseSearch(String phrase) {
        ResultSet rs = null;
        try{
            String sqlWordSearch = "SELECT * FROM \"Books\" WHERE to_tsvector(\"BookName\") @@ phraseto_tsquery(?)";
            PreparedStatement prpSearchStmt = dbConnection.prepareStatement(sqlWordSearch);
            prpSearchStmt.setString(1 , phrase);
            rs = prpSearchStmt.executeQuery();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return  rs;
    }
}

