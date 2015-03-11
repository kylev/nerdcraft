package com.kylev.nerdingcraft.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static void init(File configFile) {
        Configuration configuration = new Configuration(configFile);

        try {
            configuration.load();

            boolean configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value.").getBoolean();
        } finally {
            // Conditionally rewrite configuration file with fleshed out values.
            if (configuration.hasChanged()) {
                configuration.save();
            }
        }
    }
}
