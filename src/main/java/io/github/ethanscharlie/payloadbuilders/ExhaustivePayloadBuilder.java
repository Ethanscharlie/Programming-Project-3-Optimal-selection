package io.github.ethanscharlie.payloadbuilders;

import io.github.ethanscharlie.model.Payload;
import java.util.ArrayList;
import java.util.List;

public class ExhaustivePayloadBuilder implements PayloadBuilder {
    @Override
    public List<Payload> build(List<Payload> payloads) {
        if (payloads == null || payloads.isEmpty()) return new ArrayList<>();

        List<Payload> bestSubset = new ArrayList<>();
        int maxRating = -1;
        int bestWeight = 0;
        final int MAX_CAPACITY = 700;
        
        int n = payloads.size();
        // There are 2^n possible subsets (using bitmasking)
        long totalSubsets = 1L << n;

        for (long i = 0; i < totalSubsets; i++) {
            List<Payload> currentSubset = new ArrayList<>();
            int currentRating = 0;
            int currentWeight = 0;

            for (int j = 0; j < n; j++) {
                // If the j-th bit is set, include the j-th payload
                if ((i & (1L << j)) != 0) {
                    Payload p = payloads.get(j);
                    currentSubset.add(p);
                    currentWeight += p.weightInKilograms();
                    currentRating += p.rating();
                }
            }

            // Check if valid and if it's the best we've seen
            if (currentWeight <= MAX_CAPACITY) {
                if (currentRating > maxRating) {
                    maxRating = currentRating;
                    bestWeight = currentWeight;
                    bestSubset = new ArrayList<>(currentSubset);
                } 
                // Tie-breaker: If ratings are equal, pick the lighter total weight
                else if (currentRating == maxRating && currentWeight < bestWeight) {
                    bestWeight = currentWeight;
                    bestSubset = new ArrayList<>(currentSubset);
                }
            }
        }
        return bestSubset;
    }
}