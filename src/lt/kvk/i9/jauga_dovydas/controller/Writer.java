package lt.kvk.i9.jauga_dovydas.controller;

import lt.kvk.i9.jauga_dovydas.model.User;

import java.io.*;

/**
 * Created by Dovydas on 11/5/2016.
 */
public class Writer {
    private String data1FilePath;
    private String resultFilePath;
    private BufferedWriter bw;

    Writer() {
        data1FilePath = new File("").getAbsolutePath() + "/src/lt/kvk/i9/jauga_dovydas/data/data1.txt";
        resultFilePath = new File("").getAbsolutePath() + "/src/lt/kvk/i9/jauga_dovydas/data/result.txt";
    }

    public void appendDataToPrimaryFile(User user) {

        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter(data1FilePath, true));
            bw.write(user.getName() + "," + user.getNumber() + "," + user.getPercent());
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {                       // always close the file
            if (bw != null) try {
                bw.close();
            } catch (IOException ioe2) {
            }
        }
    }

    public void writeDataToPrimaryFile(LinkedList list) {
        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter(data1FilePath));
            if (list.start != null) {
                Node ptr = list.start;
                while (ptr.getLinkNext() != list.start) {
                    bw.write(ptr.getUserName() + "," + ptr.getUserNumber() + "," + ptr.getUserPercent());
                    bw.newLine();
                    bw.flush();
                    ptr = ptr.getLinkNext();
                }
                bw.write(ptr.getUserName() + "," + ptr.getUserNumber() + "," + ptr.getUserPercent());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {                       // always close the file
            if (bw != null) try {
                bw.close();
            } catch (IOException ioe2) {
            }
        }
    }

    public <E> void writeResultToFile(E result) {
        try {
            PrintWriter writer = new PrintWriter(resultFilePath, "UTF-8");
            writer.println(result);
            writer.close();
        } catch (Exception e) {
            // do something
        }
    }

    public void writeResultToFile(LinkedList list) throws IOException {
        try {
            bw = new BufferedWriter(new FileWriter(resultFilePath));

            if (list.start != null) {
                Node ptr = list.start;
                while (ptr.getLinkNext() != list.start) {
                    bw.write(ptr.getUserName() + "," + ptr.getUserNumber() + "," + ptr.getUserPercent());
                    bw.newLine();
                    bw.flush();
                    ptr = ptr.getLinkNext();
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        bw.close();


    }
}
