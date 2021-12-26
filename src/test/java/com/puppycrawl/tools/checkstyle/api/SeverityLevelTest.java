////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2021 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.api;

import static com.google.common.truth.Truth.assertWithMessage;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.DefaultLocale;

/**
 * Test cases for {@link SeverityLevel} enumeration.
 */
public class SeverityLevelTest {

    /* Additional test for jacoco, since valueOf()
     * is generated by javac and jacoco reports that
     * valueOf() is uncovered.
     */
    @Test
    public void testSeverityLevelValueOf() {
        final SeverityLevel level = SeverityLevel.valueOf("INFO");
        assertWithMessage("Invalid severity level")
            .that(level)
            .isEqualTo(SeverityLevel.INFO);
    }

    @Test
    public void testMisc() {
        final SeverityLevel severityLevel = SeverityLevel.getInstance("info");
        assertWithMessage("Invalid getInstance result, should not be null")
            .that(severityLevel)
            .isNotNull();
        assertWithMessage("Invalid toString result")
            .that(severityLevel.toString())
            .isEqualTo("info");
        assertWithMessage("Invalid severity level name")
            .that(severityLevel.getName())
            .isEqualTo("info");

        try {
            SeverityLevel.getInstance("unknown");
            assertWithMessage("exception expected").fail();
        }
        catch (IllegalArgumentException ex) {
            assertWithMessage("Invalid exception message")
                .that(ex.getMessage())
                .isEqualTo("No enum constant "
                    + "com.puppycrawl.tools.checkstyle.api.SeverityLevel.UNKNOWN");
        }
    }

    @Test
    public void testMixedCaseSpaces() {
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance("IgnoRe "))
            .isEqualTo(SeverityLevel.IGNORE);
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance(" iNfo"))
            .isEqualTo(SeverityLevel.INFO);
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance(" WarniNg"))
            .isEqualTo(SeverityLevel.WARNING);
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance("    ERROR "))
            .isEqualTo(SeverityLevel.ERROR);
    }

    @DefaultLocale(language = "tr", country = "TR")
    @Test
    public void testMixedCaseSpacesWithDifferentLocales() {
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance("IgnoRe "))
            .isEqualTo(SeverityLevel.IGNORE);
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance(" iNfo"))
            .isEqualTo(SeverityLevel.INFO);
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance(" WarniNg"))
            .isEqualTo(SeverityLevel.WARNING);
        assertWithMessage("Invalid getInstance result")
            .that(SeverityLevel.getInstance("    ERROR "))
            .isEqualTo(SeverityLevel.ERROR);
    }

}
