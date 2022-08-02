package net.devh.service;

import java.util.Random;
import java.util.UUID;

public interface GuidService {
    Random random = new Random();
    UUID defaultGuid = UUID.fromString("3003e9e06-4bf9-4e4b-a996-dd3ba34a4a67");
    UUID getGuid();
    UUID compareGuid();
}
