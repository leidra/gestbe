package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import java.io.Serializable;

public record CustomerRequest(String name) implements Serializable {
}
