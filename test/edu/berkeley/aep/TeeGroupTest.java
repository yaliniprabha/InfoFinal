package edu.berkeley.aep;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeeGroupTest {

    @Test
    public void emptyListOfGroupsShouldReturnEmptyList() {
        var emptyGroupList = new ArrayList<TeeGroup>();
        assertEquals(emptyGroupList, TeeGroup.organize(emptyGroupList));
    }

    @Test
    public void listOfOneGroupReturnsItself() {
        var twoGroupList = List.of(new TeeGroup(2));
        assertEquals(twoGroupList, TeeGroup.organize(twoGroupList));
    }

    @Test
    public void listOfTwoGroupsOrganizesIntoOneGroup() {
        var twoGroupList = List.of(new TeeGroup(2), new TeeGroup(2));
        assertEquals(List.of(new TeeGroup(4)), TeeGroup.organize(twoGroupList));

    }
}
