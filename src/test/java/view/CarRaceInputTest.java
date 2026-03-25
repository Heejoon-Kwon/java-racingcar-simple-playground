package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceInputTest {

    @DisplayName("5자 초과 이름은 예외를 던진다")
    @ParameterizedTest
    void getNamesInputTest() {
        CarRaceInput carRaceInput = new CarRaceInput();
        carRaceInput.getNamesInput();
    }

    @Test
    void getNumberInput() {
    }
}
