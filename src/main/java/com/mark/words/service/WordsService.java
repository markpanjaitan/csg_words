package com.mark.words.service;

import com.mark.words.model.WordResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WordsService {

	public WordResponse uploadAndCount(MultipartFile file) {

		Integer countWordStartWithM = 0;
		List<String> longWords = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
			String fileContent = reader.lines().collect(Collectors.joining(" "));
			String strWithoutPunctuation = fileContent.replaceAll("[\\p{Punct}]", " ");

			String[] words = strWithoutPunctuation.split(" ");
			for (String word : words) {
				if (!word.isEmpty()) {
					if (word.toLowerCase().startsWith("m")) {
						countWordStartWithM++;
					}

					if (word.length() > 5) {
						longWords.add(word);
					}
				}
			}
		} catch (Exception e) {
			log.info("Error >> {}", e);
		}

		return new WordResponse(countWordStartWithM, longWords);
	}

}
