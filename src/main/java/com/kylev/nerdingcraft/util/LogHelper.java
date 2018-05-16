package com.kylev.nerdingcraft.util;

import com.kylev.nerdingcraft.reference.Reference;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

/**
 * Pahimar's facade for the logging facility.
 */
public class LogHelper {
    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }

    public static void error(Object object) {
        log(Level.ERROR, object);
    }

    public static void warn(Object object) {
        log(Level.WARN, object);
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }

    public static void debug(Object object) {
        log(Level.DEBUG, object);
    }

    public static void trace(Object object) {
        log(Level.TRACE, object);
    }

    private static void log(Level logLevel, Object object) {
        FMLLog.log(Reference.MOD_NAME, logLevel, String.valueOf(object));
    }
}
