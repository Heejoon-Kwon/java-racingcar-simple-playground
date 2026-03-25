package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRaceInput {
    private final Scanner scanner;

    public CarRaceInput(){
        scanner = new Scanner(System.in);
    }

    public List<String> nameInputs(){
        List<String> names = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
        while (lineScanner.hasNext()) {
            String name = lineScanner.next();
            if (name.matches(".{1,5}")) {
                names.add(name);
                continue;
            }
            throw new RuntimeException("Invalid Name");
        }
        lineScanner.close();

        return names;
    }

    public int numberInputs(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void turnOffListener(){
        this.scanner.close();
    }
}
