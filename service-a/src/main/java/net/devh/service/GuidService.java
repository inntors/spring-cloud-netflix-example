package net.devh.service;

import java.util.Random;
import java.util.UUID;

public interface GuidService {
    UUID getGuid();
    UUID compareGuid();
}
