package com.soheb.AdaptavistTask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordFrequencyCountServiceTest {

    private WordFrequencyCountService wfcs;

    @BeforeEach
    void setUp() {
        wfcs = new WordFrequencyCountService();
    }

    @ParameterizedTest
    @MethodSource("provideForFrequencyMatches")
    void freqMatches(String resourceName, Map<String, Long> expectedMapping) throws IOException {
        var file = UnitTestUtil.getResource(resourceName);
        var frequency = wfcs.getWordFrequency(file);
        for (Map.Entry<String, Long> entry : expectedMapping.entrySet()) {
            Assertions.assertTrue(frequency.containsKey(entry.getKey()), "Could not find '%s' in returned map '%s,%d'".formatted(entry.getKey(), entry.getKey(), entry.getValue()));
            Assertions.assertEquals(entry.getValue(), frequency.get(entry.getKey()), "Assertion failed for '%s'".formatted(entry.getKey()));
        }
        Assertions.assertEquals(frequency.size(), expectedMapping.size());
    }

    private static Stream<Arguments> provideForFrequencyMatches() {
        var catResults = getCatResults();
        return Stream.of(
                Arguments.of("quick-brown-fox.txt",
                        Map.of("the",2L,
                                "quick",1L,
                                "brown",1L,
                                "fox",1L,
                                "jumps",1L,
                                "over",1L,
                                "lazy",1L,
                                "dog",1L
                        )),
                Arguments.of("quick-brown-fox-jumbled.txt",
                        Map.of("the",2L,
                                "quick",1L,
                                "brown",1L,
                                "fox",1L,
                                "jumps",1L,
                                "over",1L,
                                "lazy",1L,
                                "dog",1L
                        )),
                Arguments.of("weird-formatting.txt",
                        Map.of("hello",3L)),
                Arguments.of("cat-wikipedia.txt",
                        catResults),
                Arguments.of("long-line-file.txt",
                        Map.of("hello", 4128960L))
        );
    }

    private static Map<String, Long> getCatResults() {
        try (var lines = Files.lines(UnitTestUtil.getResource("cat-results.csv").toPath())) {
            return lines.map(line -> line.split(","))
                            .collect(Collectors.toMap(line -> line[0], line -> Long.valueOf(line[1])));
        } catch (IOException e) {
            throw new RuntimeException("Filed to get cat results", e);
        }
    }
}
