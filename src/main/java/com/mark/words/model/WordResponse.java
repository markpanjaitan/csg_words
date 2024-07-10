package com.mark.words.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WordResponse {

	@JsonProperty("count_words_start_with_m")
	private Integer countWordsStartWithM;

	@JsonProperty("words_longer_than_5")
	private List<String> longWords;

}
