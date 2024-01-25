package com.coherentsolutions.training.automation.web.sirbu.utilities;

import java.io.File;

public class FileDownloadHelper {

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File file = new File(downloadPath, fileName);
        return file.exists();
    }
}
