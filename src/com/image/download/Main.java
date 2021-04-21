package com.image.download;

import javax.swing.*;
import java.io.File;


public class Main extends JFrame{

    public static void main(String[] args) {

        String link = "https://www.rcsdk12.org/cms/lib/NY01001156/Centricity/Domain/4951/Head_First_Java_Second_Edition.pdf"; // IMPORTANT: Image URL HERE

        File out = new File("/xxxxx/xxxxxxxx/xxxxxxx/Head_First_Java_Second_Edition.pdf"); // IMPORTANT: Directory should be there and the last directory should contain the file

        new Thread(new Download(link, out)).start();
    }
}
