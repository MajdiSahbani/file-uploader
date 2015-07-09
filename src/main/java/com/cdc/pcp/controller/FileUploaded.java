package com.cdc.pcp.controller;

import org.springframework.web.multipart.MultipartFile;

/**
 * Date: 7/6/15
 * Time: 2:31 PM
 */
public class FileUploaded {
    private final MultipartFile file;
    private final String label;
    private final String comment;

    public FileUploaded(MultipartFile file, String label, String comment) {
        this.file = file;
        this.label = label;
        this.comment = comment;
    }

    public MultipartFile getFile() {
        return file;
    }

    public String getLabel() {
        return label;
    }

    public String getComment() {
        return comment;
    }
}
