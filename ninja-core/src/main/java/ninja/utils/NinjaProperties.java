package ninja.utils;

import java.util.Properties;

import com.google.inject.ImplementedBy;

@ImplementedBy(NinjaPropertiesImpl.class)
public interface NinjaProperties {
	
	/**
	 * Often you may want to use a seperate configuration file. You can
	 * define the file to use in addition to your default config
	 * at conf/application.conf by setting NINJA_EXTERNAL_CONF as
	 * JVM system property.
	 * 
	 * You must make sure that the specified file is on the classpath
	 * of the application. Eg servlet containers usually have a special
	 * directory that gets included into the classpath. That makes
	 * using different configurations for different environments quite simple.
	 * 
	 * We don't use file IO to get the file because we would most likely
	 * run into security issues easily.
	 *
	 */
	String NINJA_EXTERNAL_CONF = "ninjaExternalConf";
	
	/**
	 * The default configuration. Make sure that file exists. Otherwise
	 * the application won't start up.
	 */
	String CONF_FILE_LOCATION_BY_CONVENTION = "conf/application.conf";

	/**
	 * Get a String property or null if it is not there...
	 * 
	 * @param key
	 * @return the property of null if not there
	 */
	String get(String key);

	/**
	 * Get a property as Integer of null if not there / or property no integer
	 * 
	 * @param key
	 * @return the property or null if not there or property no integer
	 */
	Integer getInteger(String key);

	/**
	 * 
	 * @param key
	 * @return the property or null if not there or property no boolean
	 */
	Boolean getBoolean(String key);

	/**
	 * The "die" method forces this key to be set. Otherwise a runtime exception
	 * will be thrown.
	 * 
	 * @param key
	 * @return the boolean or a RuntimeException will be thrown.
	 */
	Boolean getBooleanOrDie(String key);

	/**
	 * The "die" method forces this key to be set. Otherwise a runtime exception
	 * will be thrown.
	 * 
	 * @param key
	 * @return the Integer or a RuntimeException will be thrown.
	 */
	Integer getIntegerOrDie(String key);

	/**
	 * The "die" method forces this key to be set. Otherwise a runtime exception
	 * will be thrown.
	 * 
	 * @param key
	 * @return the String or a RuntimeException will be thrown.
	 */
	String getOrDie(String key);

    /**
     * Whether we are in dev mode
     *
     * @return True if we are in dev mode
     */
    boolean isDev();
    
    /**
     * Whether we are in test mode
     *
     * @return True if we are in test mode
     */
    boolean isTest();
    
    /**
     * Whether we are in prod mode
     *
     * @return True if we are in prod mode
     */
    boolean isProd();

    /**
     * 
     * @return All properties that are currently loaded from internal and external files
     */
	Properties getAllCurrentNinjaProperties();
}
