package game.ekivoki.config.provider;

import com.geninc.ekivoki.config.reader.ConfigReader;

import java.util.Map;

import static com.geninc.ekivoki.constants.Constants.CONNECTION_CONF;

public class ConfigProvider {

    public Map<String, String> getConnectionConf() {
        return new ConfigReader().getMap(CONNECTION_CONF);
    }
}
