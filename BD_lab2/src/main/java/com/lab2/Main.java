package com.lab2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model , view);
        model.make_connection();
        controller.mainMenu();
    }
}
