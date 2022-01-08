package org.esgi.use_case.tradesman.domain;

import java.util.List;

public interface TradesmanRepository {
    void add(Tradesman tradesman);

    TradesmanId nextIdentity();

    List<Tradesman> findAll();

    Tradesman findById(TradesmanId id);

    void save(Tradesman tradesman);
}
