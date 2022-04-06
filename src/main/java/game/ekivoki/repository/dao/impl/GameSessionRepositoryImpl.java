package game.ekivoki.repository.dao.impl;

import game.ekivoki.connector.ConnectionSingleton;
import game.ekivoki.connector.QuerySingleton;
import game.ekivoki.model.GameSession;
import game.ekivoki.model.Question;
import game.ekivoki.repository.dao.GameSessionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GameSessionRepositoryImpl implements GameSessionRepository {

    @Override
    public Optional<GameSession> findOne(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            String queryStr = queryMap.getQuery("game_sessionFindById");
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryStr)) {
                ps.setLong(1, id);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    GameSession gameSession = new GameSession();
                    gameSession.setId(resultSet.getLong("id"));
                    gameSession.setSessionUuid(resultSet.getString("session_uuid"));
                    gameSession.setDateCreation(resultSet.getDate("date_creation"));
                    return Optional.of(gameSession);
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public List<GameSession> findAll() {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (Statement statement = connectionOptional.get().createStatement()) {
                ResultSet resultSet = statement.executeQuery(queryMap.getQuery("game_sessionFindById"));
                List<GameSession> result = new ArrayList<>();
                while (resultSet.next()) {
                    GameSession gameSession = new GameSession();
                    gameSession.setId(resultSet.getLong("id"));
                    gameSession.setSessionUuid(resultSet.getString("session_uuid"));
                    gameSession.setDateCreation(resultSet.getDate("date_creation"));
                    result.add(gameSession);
                }
                return result;
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<GameSession> findBySessionUUID(String sessionUUID) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            String queryStr = queryMap.getQuery("game_sessionFindByUUID");
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryStr)) {
               ps.setString(2, sessionUUID);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    GameSession gameSession = new GameSession();
                    gameSession.setId(resultSet.getLong("id"));
                    gameSession.setSessionUuid(resultSet.getString("session_uuid"));
                    gameSession.setDateCreation(resultSet.getDate("date_creation"));
                    return Optional.of(gameSession);
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<GameSession> create(GameSession gameSession) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("game_sessionCreate"), Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, gameSession.getSessionUuid());
                if (ps.executeUpdate() > 0) {
                    ResultSet resultSet = ps.getGeneratedKeys();
                    if (resultSet.next()) {
                        return findOne(resultSet.getLong(1));
                    }
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
