package game.ekivoki.repository.dao.impl;

import game.ekivoki.connector.ConnectionSingleton;
import game.ekivoki.connector.QuerySingleton;
import game.ekivoki.model.Card;
import game.ekivoki.repository.dao.CardRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CardRepositoryImpl implements CardRepository {

    @Override
    public Optional<Card> findOne(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("cardFindById"))) {
                ps.setLong(1, id);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    Card card = new Card();
                    card.setId(resultSet.getLong("id"));
                    card.setTopicId(resultSet.getLong("topic_id"));
                    card.setQuestionId(resultSet.getLong("question_id"));
                    card.setNumber(resultSet.getInt("number"));
                    card.setQuestion(resultSet.getString("question"));
                    card.setLeadTime(resultSet.getInt("lead_time"));
                    card.setDateCreation(resultSet.getDate("date_creation"));
                    card.setLastModified(resultSet.getDate("last_modified"));
                    card.setVersion(resultSet.getLong("version"));
                    return Optional.of(card);
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Card> findAll() {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (Statement statement = connectionOptional.get().createStatement()) {
                ResultSet resultSet = statement.executeQuery("cardFindAll");
                List<Card> result = new ArrayList<>();
                while (resultSet.next()) {
                    Card card = new Card();
                    card.setId(resultSet.getLong("id"));
                    card.setTopicId(resultSet.getLong("topic_id"));
                    card.setQuestionId(resultSet.getLong("question_id"));
                    card.setNumber(resultSet.getInt("number"));
                    card.setQuestion(resultSet.getString("question"));
                    card.setLeadTime(resultSet.getInt("lead_time"));
                    card.setDateCreation(resultSet.getDate("date_creation"));
                    card.setLastModified(resultSet.getDate("last_modified"));
                    card.setVersion(resultSet.getLong("version"));
                    result.add(card);
                }
                return result;
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Card> create(Card card) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("cardCreate"))) {
                ps.setLong(1, card.getTopicId());
                ps.setLong(2, card.getQuestionId());
                ps.setLong(3, card.getNumber());
                ps.setString(4, card.getQuestion());
                ps.setLong(5, card.getLeadTime());
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
    public Optional<Card> findByNumber(int number) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("cardFindByNumber"))) {
                ps.setLong(1, number);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    Card card = new Card();
                    card.setId(resultSet.getLong("id"));
                    card.setTopicId(resultSet.getLong("topic_id"));
                    card.setQuestionId(resultSet.getLong("question_id"));
                    card.setNumber(resultSet.getInt("number"));
                    card.setQuestion(resultSet.getString("question"));
                    card.setLeadTime(resultSet.getInt("lead_time"));
                    card.setDateCreation(resultSet.getDate("date_creation"));
                    card.setLastModified(resultSet.getDate("last_modified"));
                    card.setVersion(resultSet.getLong("version"));
                    return Optional.of(card);
                }
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Card> update(Card card) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("cardUpdate"))) {
                Optional<Card> optionalCard = findOne(card.getId());
                if (optionalCard.isPresent()) {
                    ps.setLong(1, card.getTopicId());
                    ps.setLong(2, card.getQuestionId());
                    ps.setInt(3, card.getNumber());
                    ps.setString(4, card.getQuestion());
                    ps.setInt(5, card.getLeadTime());
                    ps.setLong(6, card.getVersion() + 1);
                    ps.executeUpdate();
                    return findOne(card.getId());
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
            try (PreparedStatement ps = connectionOptional.get().prepareStatement(queryMap.getQuery("cardDelete"))) {
                ps.setLong(1, id);
            } catch (SQLException ex) {
                System.out.println(this.getClass().getSimpleName() + ": " + ex.getMessage());
            }
        }
    }
}
