package com.poly.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface FileManagerService {
    public byte[] read(String folder, String filename);
    public List<String> save(String folder, MultipartFile[] files);
    public void delete(String folder, String filename);
    public List<String> list(String folder);
}

