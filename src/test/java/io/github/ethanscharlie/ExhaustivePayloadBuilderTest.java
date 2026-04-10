package io.github.ethanscharlie;

import static org.junit.jupiter.api.Assertions.*;

import io.github.ethanscharlie.model.Payload;
import io.github.ethanscharlie.TestUtils;
import io.github.ethanscharlie.payloadbuilders.ExhaustivePayloadBuilder;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ExhaustivePayloadBuilderTest {

    private final ExhaustivePayloadBuilder builder = new ExhaustivePayloadBuilder();

    @Test
    public void testResultIsNotNull() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        assertNotNull(result);
    }

    @Test
    public void testWeightIsWithinLimit() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        int totalWeight = result.stream()
                .mapToInt(Payload::weightInKilograms)
                .sum();

        assertTrue(totalWeight <= 700,
                "Weight exceeded limit: " + totalWeight);
    }

    @Test
    public void testRatingIsGreaterThan50() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        int totalRating = result.stream()
                .mapToInt(Payload::rating)
                .sum();

        assertTrue(totalRating > 50,
                "Rating too low: " + totalRating);
    }

    @Test
    public void testResultIsNotEmpty() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testEmptyInput() {
        List<Payload> result = builder.build(List.of());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSinglePayloadInput() {
        Payload single = new Payload(1, "Single Payload", 100, 5);

        List<Payload> result = builder.build(List.of(single));

        assertNotNull(result);
        assertEquals(1, result.size());

        assertEquals("Single Payload", result.get(0).experiment());
        assertEquals(100, result.get(0).weightInKilograms());
        assertEquals(5, result.get(0).rating());
    }
}