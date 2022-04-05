package game.ekivoki.config.provider;

import game.ekivoki.config.reader.ConfigReader;

import java.util.Map;

import static game.ekivoki.constants.Constants.CONNECTION_CONF;

public class ConfigProvider {

    public Map<String, String> getConnectionConf() {
        return new ConfigReader().getMap(CONNECTION_CONF);
    }
}
