package org.checkstyle.suppressionxpathfilter.genericwhitespace;

import java.util.function.Consumer;

public class InputXpathGenericWhitespaceStartTwo {
    public <E> void bad(Consumer <E> consumer) {//warn
    }
    public <E> void good(Consumer<E> consumer) {
    }
}
