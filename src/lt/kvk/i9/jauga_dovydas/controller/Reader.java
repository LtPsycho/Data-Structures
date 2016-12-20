package lt.kvk.i9.jauga_dovydas.controller;

import lt.kvk.i9.jauga_dovydas.model.User;

import java.io.*;

public class Reader {
    public boolean isMoreData;
    public User[] users;
    private String csvFile;
    private BufferedReader br = null;
    private String line = "";
    private String cvsSplitBy = ",";
    private User user;

    Reader() {
        if (br == null) {
            isMoreData = true;
            csvFile = new File("").getAbsolutePath() + "/src/lt/kvk/i9/jauga_dovydas/data/data1.txt";
        }
    }

    public void getUserData(LinkedList list) {
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] client = line.split(cvsSplitBy);
                //System.out.println("Vardas: " + client[0] + " , Numeris: " + client[1] + ", Palukanos: " + client[2]);
                user = new User(client[0], Long.parseLong(client[1]), Float.parseFloat(client[2]));
                list.insertAtStart(user);
            }
            isMoreData = false;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}