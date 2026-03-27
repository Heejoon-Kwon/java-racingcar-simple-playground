package view;

import exception.InvalidNameInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class VehicleRaceNameInputTest {

    @DisplayName("이름이 5자가 아니면 InvalidNameInputException 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidNameMethodSource")
    void validateNamesWrongInputTest(List<String> invalidNames) {
        Assertions.assertThatThrownBy(() -> VehicleRaceNameInput.validateNames(invalidNames))
                .isInstanceOf(InvalidNameInputException.class).hasMessage("Name should have 5 or less characters.");
    }

    static Stream<Arguments> invalidNameMethodSource() {
        return Stream.of(
                Arguments.arguments(List.of("123456", "Tomas")),
                Arguments.arguments(List.of("")),
                Arguments.arguments(List.of("Tomas Shelby"))
                );
    }

    @DisplayName("참가자 이름은 쉼표를 기준으로 구분된다.")
    @ParameterizedTest
    @MethodSource("namesInputMethodSource")
    void getNamesTest(String userInput) {
        //given
        Scanner sc = new Scanner(userInput);
        List<String> predictedNames = Arrays.stream(userInput.split(",")).toList();
        //when
        List<String> actualNames = VehicleRaceNameInput.getNames(sc);
        //then
        Assertions.assertThat(actualNames).containsAll(predictedNames);
    }

    static Stream<Arguments> namesInputMethodSource() {
        return Stream.of(
                Arguments.arguments("sdfsd,sgsg,s]'/[,[34d'd"),
                Arguments.arguments("23['c,]]4,03.gd-d,d/'c[")
        );
    }
}
