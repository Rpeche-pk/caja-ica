package com.lrpa.app.util;

/**
 * @author ROMULO
 * @package com.lrpa.app.util
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
public final class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String API_VERSION = "/v1";
    public static final String API_BASE = "/api";
    public static final String API_POKEMON = API_BASE + API_VERSION + "/pokemon";
    public static final String API_POKEMON_NAME = "/name/{name}";
    public static final String API_POKEMON_ID =  "/id/{id}";
}
