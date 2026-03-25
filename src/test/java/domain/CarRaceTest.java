package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CarRaceTest {
    @DisplayName("우승자를 확인할 수 있다")
    @ParameterizedTest
    @MethodSource("methodSourceStringTestArguments")
    void getWinnerTest(List<String> nameList) {
        //given
        Race race = new CarRace();

        //when
        race.joinWithNames(nameList);
        race.runRounds(10);

        //then
        race.announceWinnerNames();
    }

    private static Stream<Arguments> methodSourceStringTestArguments() {
        return Stream.of(
                Arguments.arguments(List.of("Michael", "Tom", "Andrew", "Hailey", "Nancy"))
        );
    }



}
