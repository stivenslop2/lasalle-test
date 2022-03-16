/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.lasalle.api.model;


public class SearchWordResponse {
    private String searchword;
    private Integer rows;
    private String word;
    private boolean contains;
    private Integer start_row;
    private Integer start_col;

    public String getSearchword() {
        return searchword;
    }

    public void setSearchword(String searchword) {
        this.searchword = searchword;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isContains() {
        return contains;
    }

    public void setContains(boolean contains) {
        this.contains = contains;
    }

    public Integer getStart_row() {
        return start_row;
    }

    public void setStart_row(Integer start_row) {
        this.start_row = start_row;
    }

    public Integer getStart_col() {
        return start_col;
    }

    public void setStart_col(Integer start_col) {
        this.start_col = start_col;
    }

}
