package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepeatedTests {

    @DisplayName("My Repeated Test")
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition}/{totalRepetitions}")
    void myRepeatedTest() {
        // todo: add impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo info, RepetitionInfo repeatInfo) {
        System.out.println(info.getDisplayName() + " : " +
                (repeatInfo.getTotalRepetitions() + 1 - repeatInfo.getCurrentRepetition()));
    }

    @DisplayName("My Assignment Repeated Test")
    @RepeatedTest(value = 5, name = "{displayName} | {currentRepetition}/{totalRepetitions}")
    void myAssignmentRepeated() {
        //todo: add imps
    }
}
