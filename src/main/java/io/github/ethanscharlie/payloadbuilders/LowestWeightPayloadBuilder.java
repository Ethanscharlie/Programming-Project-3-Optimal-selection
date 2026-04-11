package io.github.ethanscharlie.payloadbuilders;

import io.github.ethanscharlie.model.Payload;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LowestWeightPayloadBuilder implements PayloadBuilder {
    @Override
    public List<Payload> build(List<Payload> payloads) {
        if (payloads == null) return new ArrayList<>();

        List<Payload> sorted = new ArrayList<>(payloads);

        // Logic:
        // 1. Weight (Low to High) - Primary goal: fit the most items
        // 2. Rating (High to Low) - Tie-breaker for same weight
        // 3. ID (Low to High) - Deterministic tie-breaker
        sorted.sort(Comparator.comparingInt(Payload::weightInKilograms)
                .thenComparing(Comparator.comparingInt(Payload::rating).reversed())
                .thenComparingInt(Payload::id));

        List<Payload> selected = new ArrayList<>();
        int currentWeight = 0;
        final int MAX_CAPACITY = 700;

        for (Payload p : sorted) {
            if (currentWeight + p.weightInKilograms() <= MAX_CAPACITY) {
                selected.add(p);
                currentWeight += p.weightInKilograms();
            }
        }
        return selected;
    }
}