package io.github.ethanscharlie;

import static org.junit.jupiter.api.Assertions.*;

import io.github.ethanscharlie.model.Payload;
import io.github.ethanscharlie.TestUtils;
import java.util.List;

import io.github.ethanscharlie.payloadbuilders.BestRatingPayloadBuilder;
import org.junit.jupiter.api.Test;

public class BestRatingPayloadBuilderTest {

    private final BestRatingPayloadBuilder builder = new BestRatingPayloadBuilder();

    @Test
    public void testMatchingList() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        assertNotNull(result);
        assertEquals(5, result.size());

        assertEquals("Solar Flares", result.get(0).experiment());
        assertEquals("Micrometeorites", result.get(1).experiment());
        assertEquals("Mice Tumors", result.get(2).experiment());
        assertEquals("Relativity", result.get(3).experiment());
        assertEquals("Binary Stars", result.get(4).experiment());

        int totalRating = result.stream()
                .mapToInt(Payload::rating)
                .sum();
        assertEquals(42, totalRating);

        int totalWeight = result.stream()
                .mapToInt(Payload::weightInKilograms)
                .sum();
        assertEquals(672, totalWeight);
    }

    @Test
    public void testEmptyList() {
        List<Payload> result = builder.build(List.of());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testListWithOneElement() {
        Payload single = new Payload(99, "Test Payload", 50, 7);

        List<Payload> result = builder.build(List.of(single));

        assertNotNull(result);
        assertEquals(1, result.size());

        assertEquals("Test Payload", result.get(0).experiment());
        assertEquals(50, result.get(0).weightInKilograms());
        assertEquals(7, result.get(0).rating());
    }
}