package com.soheb.AdaptavistTask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Map;
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
            Assertions.assertTrue(frequency.containsKey(entry.getKey()));
            Assertions.assertEquals(entry.getValue(), frequency.get(entry.getKey()));
        }
    }

    private static Stream<Arguments> provideForFrequencyMatches() {
        return Stream.of(
                Arguments.of("test1.txt",
                        Map.of("the",2L,
                                "quick",1L,
                                "brown",1L,
                                "fox",1L,
                                "jumps",1L,
                                "over",1L,
                                "lazy",1L,
                                "dog",1L
                        )),
                Arguments.of("test2.txt",
                        Map.of("the",2L,
                                "quick",1L,
                                "brown",1L,
                                "fox",1L,
                                "jumps",1L,
                                "over",1L,
                                "lazy",1L,
                                "dog",1L
                        ))
        );
    }
}
