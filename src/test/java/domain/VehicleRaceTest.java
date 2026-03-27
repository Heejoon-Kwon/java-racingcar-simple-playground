package domain;

import exception.InvalidNameInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRaceTest {

    @DisplayName("이름들을 주면 참가자 명단에 넣어준다.")
    @ParameterizedTest
    @MethodSource("stringListOfNamesMethodSource")
    void joinWithNamesTest(List<String> names) {
        //given
        Race race = new VehicleRace();

        //when
        race.joinWithNames(names);

        //then
        Assertions.assertThat(race.getParticipants().stream().map(Participant::getName).toList()).containsAll(names);
    }

    static Stream<Arguments> stringListOfNamesMethodSource() {
        return Stream.of(
                Arguments.arguments(List.of("Michael", "Tom", "Dex")),
                Arguments.arguments(List.of("A", "BB", "CCC", "DDDD"))
        );
    }

    @DisplayName("가장 많이 전진한 차량이 우승한다.")
    @Test
    void getWinnerNamesSingleWinnerTest() {
        //given
        Race race = new VehicleRace();

        //when
        race.joinWithNames(List.of("Win", "Lose1", "Lose2"));
        Participant participant1 = race.getParticipants().get(0);
        Participant participant2 = race.getParticipants().get(1);
        Participant participant3 = race.getParticipants().get(2);

        participant1.moveForward(9);
        participant1.moveForward(9);
        participant2.moveForward(1);
        participant2.moveForward(9);
        participant3.moveForward(1);
        participant3.moveForward(1);

        //then
        Assertions.assertThat(race.getWinnerNames()).containsOnly("Win");
    }

    @DisplayName("가장 많이 전진한 차량이 2대이면 공동우승한다.")
    @Test
    void getWinnerNamesDoubleWinnersTest() {
        //given
        Race race = new VehicleRace();

        //when
        race.joinWithNames(List.of("Win1", "Win2", "Lose1", "Lose2"));
        Participant participant1 = race.getParticipants().get(0);
        Participant participant2 = race.getParticipants().get(1);
        Participant participant3 = race.getParticipants().get(2);
        Participant participant4 = race.getParticipants().get(3);

        participant1.moveForward(9);
        participant1.moveForward(9);
        participant2.moveForward(9);
        participant2.moveForward(9);
        participant3.moveForward(1);
        participant3.moveForward(9);
        participant4.moveForward(1);
        participant4.moveForward(1);

        //then
        Assertions.assertThat(race.getWinnerNames()).containsOnly("Win1", "Win2");
    }
}
