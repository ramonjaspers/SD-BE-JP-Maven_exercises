package nl.novi.jp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void nameShouldNotBeChangedDuringCreation() {
        //init person with name nick
        Person person = new Person("Nick");
        assertEquals("Nick", person.getName());
    }

    @Test
    public void personWithoutNameShouldBeNamedJohn() {
        //init empty person
        Person person = new Person();
        assertEquals("John", person.getName());
    }

    @Test
    public void ageShouldAddOneYear() {
        //init nick and set age to 68
        Person person = new Person("Nick");
        person.setAge(68);
        //call function which increases age by1
        person.increaseAge();
        assertEquals(69, person.getAge());
    }

    @Test
    public void lastNameShouldStartWithUpperCaseWhenLowercaseGiven() {
        Person person = new Person("Henk");
        person.setLastName("random");
        assertEquals("Random", person.getLastName());
    }

    @Test
    public void lastNameShouldStartWithUppercase() {
        Person person = new Person("Harry");
        person.setLastName("Potter");
        assertEquals("Potter", person.getLastName());
    }

    @Test
    public void givenNoPartnerHasPartnerShouldReturnFalse() {
        Person foreverAlone = new Person();
        assertFalse(foreverAlone.hasPartner());
    }

    @Test
    public void givenAPartnerHasPartnerShouldReturnTrue() {
        Person happilyMarried = new Person();
        Person unhappilyMarried = new Person();
        happilyMarried.setPartner(unhappilyMarried);
        unhappilyMarried.setPartner(happilyMarried);
        assertTrue(happilyMarried.hasPartner());
        assertTrue(unhappilyMarried.hasPartner());
    }

    @Test
    public void childShouldBeAddedToList() {
        Person person = new Person();
        Person child = new Person();
        person.addChild(child);
        //  Technically not Clean Code
        assertEquals(1, person.getChildren().size());
        assertEquals(child.getName(), person.getChildren().get(0).getName());
    }

    @Test
    public void childWithNonUniqueNameCannotBeAddedToList() {
        Person person = new Person();
        Person child = new Person();
        Person duplicateChild = new Person();
        person.addChild(child);
        person.addChild(duplicateChild);
        assertEquals(1, person.getChildren().size());
    }
}
