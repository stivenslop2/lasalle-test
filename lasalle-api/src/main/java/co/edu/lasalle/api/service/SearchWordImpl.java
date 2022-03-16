package co.edu.lasalle.api.service;

import org.springframework.stereotype.Service;
import co.edu.lasalle.api.model.SearchWordRequest;
import co.edu.lasalle.api.model.SearchWordResponse;

@Service
public class SearchWordImpl implements SearchWord {
    
    // Punto Numero 1 Prueba Tpecnica
    public boolean executeScript(char[][]matrix, String word){       
        SearchWordResponse searchWordResult = new SearchWordResponse();     
        searchWordResult = findWordInVerticalAndHorizontal(searchWordResult, matrix, word);
        return searchWordResult.isContains();
        
    }


    // Punto Numero 2 Prueba Tpecnica
    @Override
    public SearchWordResponse isWordInVerticalAndHorizontal(SearchWordRequest bodyRequest) {

        SearchWordResponse searchWordResult = new SearchWordResponse();
        searchWordResult.setSearchword(bodyRequest.getSearchword());
        searchWordResult.setRows(bodyRequest.getRows());
        searchWordResult.setWord(bodyRequest.getWord());
        
        char[][] searchWord = formatToMatrix(bodyRequest);

        searchWordResult = findWordInVerticalAndHorizontal(searchWordResult, searchWord, bodyRequest.getWord());

        return searchWordResult;
    }
    
    // Punto Numero 3 Prueba Tpecnica
    @Override
    public SearchWordResponse isWordInDiagonal(SearchWordRequest bodyRequest) {

        SearchWordResponse searchWordResult = new SearchWordResponse();
        searchWordResult.setSearchword(bodyRequest.getSearchword());
        searchWordResult.setRows(bodyRequest.getRows());
        searchWordResult.setWord(bodyRequest.getWord());
        
        char[][] searchWord = formatToMatrix(bodyRequest);

        searchWordResult = findWordInVerticalAndHorizontal(searchWordResult, searchWord, bodyRequest.getWord());
        if(!searchWordResult.isContains()) searchWordResult = findWordInDiagonal(searchWordResult, searchWord, bodyRequest.getWord());
       
        return searchWordResult;
    }

    private static char[][] formatToMatrix(SearchWordRequest bodyRequest) {
        Integer rows = bodyRequest.getRows();
        Integer columns = bodyRequest.getSearchword().length() / bodyRequest.getRows();
        String searchWord = bodyRequest.getSearchword();

        char[][] matrix = new char[rows][columns];
        char[] arr = searchWord.toCharArray();

        int k = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j] = arr[k];
                ++k;
            }
        }

        return matrix;

    }

    private SearchWordResponse findWordInVerticalAndHorizontal(SearchWordResponse searchWordResult, char[][] searchWord, String word) {
        boolean isWordIn = false;
        Integer[] coordinates = new Integer[]{-1, -1, -1};

        for (int row = 0; row < searchWord.length; row++) {
            for (int column = 0; column < searchWord[row].length; column++) {

                // busca derecha
                if (column + (word.length() - 1) < searchWord[row].length) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row][column + letras]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 2;
                    }
                }

                // busca izquierda
                if (column - (word.length() - 1) >= 0) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row][column - letras]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 6;
                    }
                }

                // busca abajo
                if (row + (word.length() - 1) < searchWord.length) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row + letras][column]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 4;
                    }
                }

                // busca arriba
                if (row - (word.length() - 1) >= 0) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row - letras][column]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 0;
                    }
                }

            }
        }

        searchWordResult.setContains(isWordIn);
        searchWordResult.setStart_row(coordinates[0]);
        searchWordResult.setStart_col(coordinates[1]);

        return searchWordResult;
    }
    
    private SearchWordResponse findWordInDiagonal(SearchWordResponse searchWordResult, char[][] searchWord, String word) {
        boolean isWordIn = false;
        Integer[] coordinates = new Integer[]{-1, -1, -1};

        for (int row = 0; row < searchWord.length; row++) {
            for (int column = 0; column < searchWord[row].length; column++) {

              
                // diagonal arriba derecha
                if ((row - (word.length() - 1) >= 0) && (column + (word.length() - 1) < searchWord[row].length)) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row - letras][column + letras]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 1;
                    }
                }
                //

                // diagonal arriba izquierda
                if ((row - (word.length() - 1) >= 0) && (column - (word.length() - 1) >= 0)) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row - letras][column - letras]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 7;
                    }
                }

                // diagonal abajo derecha
                if ((row + (word.length() - 1) < searchWord.length) && (column + (word.length() - 1) <= searchWord[row].length)) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row + letras][column + letras]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 3;
                    }
                }

                // diagonal abajo izquierda
                if ((row + (word.length() - 1) < searchWord.length) && (column - (word.length() - 1) >= 0)) {
                    boolean founded = true;

                    for (int letras = 0; letras < word.length(); letras++) {
                        if (word.charAt(letras) != searchWord[row + letras][column - letras]) {
                            founded = false;
                            break;
                        }
                    }
                    if (founded) {
                        isWordIn = true;
                        coordinates[0] = row;
                        coordinates[1] = column;
                        coordinates[2] = 5;
                    }
                }

            }
        }

        searchWordResult.setContains(isWordIn);
        searchWordResult.setStart_row(coordinates[0]);
        searchWordResult.setStart_col(coordinates[1]);

        return searchWordResult;
    }

}
