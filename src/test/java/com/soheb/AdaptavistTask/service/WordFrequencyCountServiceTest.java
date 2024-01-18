package com.soheb.AdaptavistTask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
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
    void freqMatches(String resourceName, Map<String, Integer> expectedMapping) throws IOException, URISyntaxException {
        var file = UnitTestUtil.getResource(resourceName);
        var frequency = wfcs.getWordFrequency(file);
        for (Map.Entry<String, Integer> entry : expectedMapping.entrySet()) {
            Assertions.assertTrue(frequency.containsKey(entry.getKey()));
            Assertions.assertEquals(entry.getValue(), frequency.get(entry.getKey()));
        }
    }

    private static Stream<Arguments> provideForFrequencyMatches() {
        return Stream.of(
                Arguments.of("test1.txt",
                        Map.of("the",2,
                                "quick",1,
                                "brown",1,
                                "fox",1,
                                "jumps",1,
                                "over",1,
                                "lazy",1,
                                "dog",1
                        )),
                Arguments.of("test2.txt",
                        Map.of("the",2,
                                "quick",1,
                                "brown",1,
                                "fox",1,
                                "jumps",1,
                                "over",1,
                                "lazy",1,
                                "dog",1
                        ))
        );
    }

    @Test
    void frequencyMatches() throws IOException, URISyntaxException {
        var file = UnitTestUtil.getResource("test1.txt");
        var frequency = wfcs.getWordFrequency(file);
        Assertions.assertTrue(frequency.containsKey("the"));
        Assertions.assertTrue(frequency.containsKey("quick"));
        Assertions.assertTrue(frequency.containsKey("brown"));
        Assertions.assertTrue(frequency.containsKey("fox"));
        Assertions.assertTrue(frequency.containsKey("jumps"));
        Assertions.assertTrue(frequency.containsKey("over"));
        Assertions.assertTrue(frequency.containsKey("the"));
        Assertions.assertTrue(frequency.containsKey("lazy"));
        Assertions.assertTrue(frequency.containsKey("dog"));
        Assertions.assertEquals(2, frequency.get("the"));
        Assertions.assertEquals(1, frequency.get("quick"));
        Assertions.assertEquals(1, frequency.get("brown"));
        Assertions.assertEquals(1, frequency.get("fox"));
        Assertions.assertEquals(1, frequency.get("jumps"));
        Assertions.assertEquals(1, frequency.get("over"));
        Assertions.assertEquals(1, frequency.get("lazy"));
        Assertions.assertEquals(1, frequency.get("dog"));
    }

    @Test
    void frequencyMatches2() throws IOException, URISyntaxException {
        var file = UnitTestUtil.getResource("test2.txt");
        var frequency = wfcs.getWordFrequency(file);
        Assertions.assertTrue(frequency.containsKey("the"));
        Assertions.assertTrue(frequency.containsKey("quick"));
        Assertions.assertTrue(frequency.containsKey("brown"));
        Assertions.assertTrue(frequency.containsKey("fox"));
        Assertions.assertTrue(frequency.containsKey("jumps"));
        Assertions.assertTrue(frequency.containsKey("over"));
        Assertions.assertTrue(frequency.containsKey("the"));
        Assertions.assertTrue(frequency.containsKey("lazy"));
        Assertions.assertTrue(frequency.containsKey("dog"));
        Assertions.assertEquals(2, frequency.get("the"));
        Assertions.assertEquals(1, frequency.get("quick"));
        Assertions.assertEquals(1, frequency.get("brown"));
        Assertions.assertEquals(1, frequency.get("fox"));
        Assertions.assertEquals(1, frequency.get("jumps"));
        Assertions.assertEquals(1, frequency.get("over"));
        Assertions.assertEquals(1, frequency.get("lazy"));
        Assertions.assertEquals(1, frequency.get("dog"));
    }
}
