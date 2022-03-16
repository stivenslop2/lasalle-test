package co.edu.lasalle.api.service;

import co.edu.lasalle.api.model.SearchWordRequest;
import co.edu.lasalle.api.model.SearchWordResponse;

public interface SearchWord {
    SearchWordResponse isWordInVerticalAndHorizontal(SearchWordRequest request);
    SearchWordResponse isWordInDiagonal(SearchWordRequest request);
}
