package com.kylev.nerdingcraft.api;

import com.kylev.nerdingcraft.util.LogHelper;

/**
 * An absurd, useless public API class.
 */
public class Greeter {
    public static void greet(String name) {
        LogHelper.info("Saying hello to " + name);
    }
}
