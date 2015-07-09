package com.cdc.pcp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Date: 7/2/15
 * Time: 1:17 PM
 */
@RestController
@RequestMapping(value = "/a/upload", produces = MediaType.APPLICATION_JSON_VALUE)
public class UploadController {

    public static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    private static int counter = 1;

    private final ExecutorService executorService;

    public UploadController() {
        executorService = Executors.newFixedThreadPool(10);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ping() {
        return "ping";
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean upload(@RequestParam("file") MultipartFile file, @RequestParam("label") String label, @RequestParam("comment") String comment) {
        final FileUploaded fileUploaded = new FileUploaded(file, label, comment);
        executorService.submit(() -> {
            logger.info("counter --------------------> " + counter++);
            logger.info("label " + fileUploaded.getLabel());
            logger.info("comment " + fileUploaded.getComment());
            logger.info("filename " + fileUploaded.getFile().getOriginalFilename());
            logger.info("file size " + fileUploaded.getFile().getSize());
        });
        return true;
    }


}
