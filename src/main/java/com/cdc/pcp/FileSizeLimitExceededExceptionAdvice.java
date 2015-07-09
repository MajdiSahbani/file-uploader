package com.cdc.pcp;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 7/3/15
 * Time: 12:35 PM
 */
@ControllerAdvice
public class FileSizeLimitExceededExceptionAdvice {

    @ExceptionHandler(FileUploadBase.FileSizeLimitExceededException.class)
    public void handleFileSizeLimitExceededException(MaxUploadSizeExceededException e, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("FileSizeLimitExceededException","true");
    }
}
