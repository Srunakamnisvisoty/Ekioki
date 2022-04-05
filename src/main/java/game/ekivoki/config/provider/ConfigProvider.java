package game.ekivoki.config.provider;

import game.ekivoki.config.reader.ConfigReader;

import java.util.Map;

import static game.ekivoki.constants.Constants.CONNECTION_CONF;
import static game.ekivoki.constants.Constants.QUERY_LIST;

public class ConfigProvider {

    public Map<String, String> getConnectionConf() {
        return new ConfigReader().getMap(CONNECTION_CONF);
    }

    public Map<String, String> queryMap() {
        return new ConfigReader().getMap(QUERY_LIST);
    }
}
