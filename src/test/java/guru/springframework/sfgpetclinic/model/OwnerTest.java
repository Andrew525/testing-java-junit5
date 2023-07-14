package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Key West"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String var) {
        System.out.println(var);
    }


    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("Csv Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource(value = {
            " FL;1;1",
            "OH;2; 2",
            "MI; 3;3"},
            delimiter = ';')
    void csvInputTest(String stateNmae, int var1, int var2) {
        System.out.println("'"+stateNmae + "' = " + var1 + ":" + var2);
    }

    @DisplayName("Csv Input From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource( delimiter = ';', numLinesToSkip = 1, resources = "/input.csv")
    void csvFromFileTest(String stateName, int var1, int var2) {
        System.out.println("'"+stateName + "' = " + var1 + ":" + var2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("provideArgs")
    void fromMethodTest(String stateName, int var1, int var2) {
        System.out.println("'"+stateName + "' = " + var1 + ":" + var2);
    }

    static Stream<Arguments> provideArgs() { // note! it should be static
        return Stream.of(
                Arguments.of("FL", 1, 1 ),
//                Arguments.of(), error if empty
                Arguments.of(" OH ",2,2));
    }

    @DisplayName("Custom Args Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomArgsProviderTest(String stateName, int var1, int var2) {
        System.out.println("'"+stateName + "' = " + var1 + ":" + var2);
    }


}