package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configurations/driver.properties")
public interface DriverConfig extends Config {

    @Key("remote.web.driver")
    String getRemoteWebDriver();

    @Key("remote.web.user")
    String getRemoteWebUser();

    @Key("remote.web.password")
    String getRemoteWebPassword();

    @DefaultValue("chrome")
    @Key("web.browser")
    String getWebBrowser();

    @Key("video.storage")
    String getVideoStorage();
}