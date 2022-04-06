package game.ekivoki.repository.dao.impl;

import game.ekivoki.connector.ConnectionSingleton;
import game.ekivoki.connector.QuerySingleton;
import game.ekivoki.model.Card;
import game.ekivoki.repository.dao.CardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CardRepositoryImpl implements CardRepository {

    @Override
    public Optional<Card> findOne(Long id) {
        Optional<Connection> connectionOptional = ConnectionSingleton.instance(Optional.empty()).getConnection();
        QuerySingleton queryMap = QuerySingleton.instance(null);
        if (connectionOptional.isPresent()) {
            try(PreparedStatement ps = connectionOptional.get().prepareStatement("cardFindById")) {
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
        return null;
    }

    @Override
    public Optional<Card> create(Card model) {
        return Optional.empty();
    }

    @Override
    public Optional<Card> findByNumber(int number) {
        return Optional.empty();
    }

    @Override
    public Optional<Card> update(Card card) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
