package org.sample.bdd.tdd.course;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SectionTest {

    @Test
    public void Constructor_shouldReturn_TheGiven_Property(){
        int id=1;
        String sectionName="Tdd";

        Section section=new Section(id,sectionName);
        assertThat(id).isEqualTo(section.getId());
        assertThat(sectionName).isEqualTo(section.getSectionName());
    }
}
