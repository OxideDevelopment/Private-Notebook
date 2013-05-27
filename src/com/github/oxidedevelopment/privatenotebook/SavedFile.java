package com.github.oxidedevelopment.privatenotebook;

import java.io.Serializable;

/**
 * Created by: Justin
 * Date: 5/23/13
 * Time: 2:26 PM
 */
public class SavedFile implements Serializable {

    String pw;
    String title;
    String body;

    public SavedFile(String pw, String title, String body) {
        this.pw = pw;
        this.title = title;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getPw() {
        return pw;
    }

    public String getTitle() {
        return title;
    }
}
