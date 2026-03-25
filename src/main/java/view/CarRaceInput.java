package view;

import exception.InvalidNameInputException;
import exception.InvalidNumberInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarRaceInput {
    private final Scanner scanner;

    public CarRaceInput(){
        scanner = new Scanner(System.in);
    }

    public List<String> getNamesInput() {
        List<String> names = CarRaceNameInput.getNames(scanner);

        try {
            CarRaceNameInput.validateNames(names);
        } catch (InvalidNameInputException e) {
            System.out.println(e.getMessage());
            return getNamesInput();
        }

        return  names;
    }

    public int getNumberInput() {
        int number;

        try {
            number = CarRaceNumberInput.getNumber(scanner);
        } catch (InvalidNumberInputException e) {
            System.out.println(e.getMessage());
            return getNumberInput();
        }

        return number;
    }



    public void turnOffScanner(){
        this.scanner.close();
    }
}
