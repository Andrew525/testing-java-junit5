package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

/**
 * Created by jt on 2018-10-28.
 */
@Tag("model")
@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachConsoleOutputer(TestInfo info, RepetitionInfo rInfo) {
        System.out.println("Running Test -" + info.getDisplayName() +
                " - " +
                rInfo.getCurrentRepetition() +
                " | " +
                rInfo.getTotalRepetitions());
    }
}
