package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:configurations/local_driver.properties",
        "classpath:configurations/remote_driver.properties"
})
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