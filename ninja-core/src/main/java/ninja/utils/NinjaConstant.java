package ninja.utils;

public interface NinjaConstant {
	
    // /////////////////////////////////////////////////
    // The 3 basic modes for ninja.
	// they should be set as system property: -Dmode=test
	// and so on
	String MODE_KEY_NAME = "mode";
	//and the values for the modes:
	String MODE_TEST = "test";
	String MODE_DEV = "dev";
	String MODE_PROD = "prod";

    // /////////////////////////////////////////////////
    // The basic directories used in all convention
    // over configuration operations:
    String VIEWS_DIR = "views";
    String CONTROLLERS_DIR = "controllers";
    String MODELS_DIR = "models";

    /** 
     * Prefix used for all Ninja cookies. 
     * 
     * Make sure you set the prefix in your application.conf file.
     * 
     * */
    final String applicationCookiePrefix = "applicationCookiePrefix";

    /**
     * Suffix used for Ninja cookies. Usually results
     * in cookies like "NINJA_SESSION
     */
    final String SESSION_SUFFIX = "_SESSION";

    /**
     * Suffix used for Ninja cookies. Usually results
     * in cookies like "NINJA_FLASH
     */
    final String FLASH_SUFFIX = "_FLASH";

    /** used as spacer for instance in session cookie */
    final String UNI_CODE_NULL_ENTITY = "\u0000";

    /** yea. utf-8 */
    final String UTF_8 = "utf-8";

    /** Used to verify client side cookie for instance. */
    final String applicationName = "applicationName";

    /** Used to verify client side cookie for instance. */
    final String applicationSecret = "applicationSecret";

    /**
     * In many situations the server cannot know its own name. So
     * You can set using that variable.
     */
    final String serverName = "serverName";

}
