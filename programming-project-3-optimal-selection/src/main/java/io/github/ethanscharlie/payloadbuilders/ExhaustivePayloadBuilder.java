package io.github.ethanscharlie.payloadbuilders;

import io.github.ethanscharlie.model.Payload;
import java.util.List;

public class ExhaustivePayloadBuilder implements PayloadBuilder {
    public List<Payload> build(List<Payload> availablePayloads) {
        return availablePayloads;
    }
}
