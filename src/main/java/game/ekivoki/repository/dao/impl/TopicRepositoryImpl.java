package game.ekivoki.repository.dao.impl;

import game.ekivoki.connector.ConnectionSingleton;
import game.ekivoki.connector.QuerySingleton;
import game.ekivoki.model.Topic;
import game.ekivoki.repository.dao.TopicRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TopicRepositoryImpl implements TopicRepository {

    @Override
    public Optional<Topic> findOne(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            String queryStr = queryMap.getQuery("topicFindOneById");
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryStr)) {
                ps.setLong(1, id);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    Topic topic = new Topic();
                    topic.setId(resultSet.getLong("id"));
                    topic.setName(resultSet.getString("name"));
                    return Optional.of(topic);
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Topic> findAll() {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (Statement statement = connectionOptional.get().createStatement()) {
                ResultSet resultSet = statement.executeQuery(queryMap.getQuery("topicFindAll"));
                List<Topic> result = new ArrayList<>();
                while (resultSet.next()) {
                    Topic topic = new Topic();
                    topic.setId(resultSet.getLong("id"));
                    topic.setName(resultSet.getString("name"));
                    result.add(topic);
                }
                return result;
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Topic> create(Topic topic) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("topicCreate"), Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, topic.getName());
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
    public Optional<Topic> update(Topic topic) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("topicUpdate"))) {
                Optional<Topic> optionalTopic = findOne(topic.getId());
                if (optionalTopic.isPresent()) {
                    ps.setString(1, topic.getName());
                    ps.executeUpdate();
                    return findOne(topic.getId());
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("topicDeleteById"))) {
                ps.setLong(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
    }
}
