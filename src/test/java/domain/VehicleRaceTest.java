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
}
