package com.p.service.export.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {
    public static void main(final String[] args) throws IOException {
        final String sourceFile = "C:\\Users\\premendra.kumar\\Desktop\\json-data";
        final FileOutputStream fos = new FileOutputStream("C:\\Users\\premendra.kumar\\Desktop\\json-data-output\\dirCompressed.zip");
        final ZipOutputStream zipOut = new ZipOutputStream(fos);
        final File fileToZip = new File(sourceFile);

        zipFile(fileToZip, fileToZip.getName(), zipOut);
        zipOut.close();
        fos.close();
    }
    
    public static void zip(String sourceFolder,String targetFolder, String zipFileName) throws IOException {
    	final String sourceFile = sourceFolder;
        final FileOutputStream fos = new FileOutputStream(targetFolder+File.separator+zipFileName);
        final ZipOutputStream zipOut = new ZipOutputStream(fos);
        final File fileToZip = new File(sourceFile);

        zipFile(fileToZip, fileToZip.getName(), zipOut);
        zipOut.close();
        fos.close();
    }

    private static void zipFile(final File fileToZip, final String fileName, final ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            final File[] children = fileToZip.listFiles();
            for (final File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        final FileInputStream fis = new FileInputStream(fileToZip);
        final ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        final byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}