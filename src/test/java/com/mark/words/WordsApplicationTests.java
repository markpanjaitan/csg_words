package com.mark.words;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.mark.words.service.WordsService;

import com.mark.words.model.WordResponse;

@SpringBootTest
class WordsApplicationTests {

	private final WordsService wordsService = new WordsService();

	@Test
	public void testProcessFile() throws IOException {
		String content = "Mango, apple, banana, milk and melon in MerryGoRound!!";
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", content.getBytes());

		WordResponse result = wordsService.uploadAndCount(file);
		
		List<String> expectedLongWords = Arrays.asList("banana", "MerryGoRound");

		assertEquals(4, result.getCountWordsStartWithM());
		assertEquals(expectedLongWords, result.getLongWords());
	}

}
