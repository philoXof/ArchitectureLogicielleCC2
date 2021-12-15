package org.esgi.infrastructure;

import org.esgi.domain.tradesman.Tradesman;
import org.esgi.domain.tradesman.TradesmanId;
import org.esgi.domain.tradesman.TradesmanRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryTradesmanRepository implements TradesmanRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<TradesmanId, Tradesman> data = new HashMap<>();

    @Override
    public void add(Tradesman tradesman) {
        data.put(tradesman.getTradesmanId(), tradesman);
    }

    @Override
    public TradesmanId nextIdentity() {
        return TradesmanId.of(counter.incrementAndGet());
    }

    @Override
    public List<Tradesman> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Tradesman findById(TradesmanId id) {
        final Tradesman tradesman = data.get(id);
        if(tradesman == null) {
            throw new RuntimeException("No user for " + id.getValue());
        }
        return tradesman;
    }

    @Override
    public void save(Tradesman tradesman) {
        data.put(tradesman.getTradesmanId(), tradesman);
    }
}
