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
    public static final String API_POKEMON_ID = API_POKEMON + "/{id}";
    public static final String API_POKEMON_NAME = API_POKEMON + "/name/{name}";
    public static final String API_POKEMON_TYPE = API_POKEMON + "/type/{type}";
    public static final String API_POKEMON_FEEDING = API_POKEMON + "/feeding/{feeding}";
    public static final String API_POKEMON_SIZE = API_POKEMON + "/size/{size}";
    public static final String API_POKEMON_WEIGHT = API_POKEMON + "/weight/{weight}";
    public static final String API_POKEMON_RARITY = API_POKEMON + "/rarity/{rarity}";
    public static final String API_POKEMON_FUNFACT = API_POKEMON + "/funfact/{funfact}";
    public static final String API_POKEMON_PAGINATION = API_POKEMON + "/pagination";
    public static final String API_POKEMON_PAGINATION_SORT = API_POKEMON_PAGINATION + "/sort";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD = API_POKEMON_PAGINATION_SORT + "/{field}";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD_ORDER = API_POKEMON_PAGINATION_SORT_FIELD + "/{order}";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE = API_POKEMON_PAGINATION_SORT_FIELD_ORDER + "/{page}";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE = API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE + "/{size}";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE_ALL = API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE + "/all";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE_ALL_COUNT = API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE_ALL + "/count";
    public static final String API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE_ALL_COUNT_TOTAL = API_POKEMON_PAGINATION_SORT_FIELD_ORDER_PAGE_SIZE_ALL_COUNT + "/total";
}
