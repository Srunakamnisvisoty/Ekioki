package game.ekivoki.repository.dao.impl;

import game.ekivoki.connector.ConnectionSingleton;
import game.ekivoki.connector.QuerySingleton;
import game.ekivoki.model.Question;
import game.ekivoki.repository.dao.QuestionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class QuestionRepositoryImpl implements QuestionRepository {

    @Override
    public Optional<Question> findOne(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            String queryStr = queryMap.getQuery("questionFindOneById");
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryStr)) {
                ps.setLong(1, id);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    Question question = new Question();
                    question.setId(resultSet.getLong("id"));
                    question.setName(resultSet.getString("name"));
                    question.setDescription(resultSet.getString("description"));
                    return Optional.of(question);
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Question> findAll() {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (Statement statement = connectionOptional.get().createStatement()) {
                ResultSet resultSet = statement.executeQuery(queryMap.getQuery("questionFinaAll"));
                List<Question> result = new ArrayList<>();
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setId(resultSet.getLong("id"));
                    question.setName(resultSet.getString("name"));
                    question.setDescription(resultSet.getString("description"));
                    result.add(question);
                }
                return result;
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void remove(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("questionDeleteById"))) {
                ps.setLong(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
    }
}
