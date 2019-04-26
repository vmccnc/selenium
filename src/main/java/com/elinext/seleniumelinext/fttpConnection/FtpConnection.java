package com.elinext.seleniumelinext.fttpConnection;

import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpConnection {

    public static void main(String[] args) {

        FTPClient client = new FTPClient();

        try {
            System.out.println("Try to connect !");
            client.connect("ftp.byfly.by");

// Try to login and return the respective boolean value
            boolean login = client.login("anonymous", "anonymous");
            System.out.println("Try to connect 2!");
// If login is true notify user

            if (login) {

                System.out.println("Connection established...");

                // get all files from server and store them in an array of
                // FTPFiles
                FTPFile[] files = client.listDirectories();

                for (FTPFile file : files) {
                    if (file.getType() == FTPFile.DIRECTORY_TYPE) {
                        System.out.println("File Name: "
                                + file.getName()
                                + " File Size: "
                                + FileUtils.byteCountToDisplaySize(file
                                .getSize()));
                    }
                }



                // Try to logout and return the respective boolean value
                boolean logout = client.logout();






                // If logout is true notify user
                if (logout) {

                    System.out.println("Connection close...");

                }
//  Notify user for failure
            } else {
                System.out.println("Connection fail...");
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                // close connection

                client.disconnect();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }
}