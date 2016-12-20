package lt.kvk.i9.jauga_dovydas.controller;

import lt.kvk.i9.jauga_dovydas.model.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static User user;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();

        Reader reader = new Reader();
        Writer writer = new Writer();

        String name;
        Long number;
        Float percent;

        char ch;
        do {
            System.out.println("\nDvipusio ciklinio sarašo operacijos\n");
            System.out.println("1. nuskaityti duomenų failus ir užpildyti masyvą");
            System.out.println("2. iterpti pradžioje");
            System.out.println("3. iterptį pagal reikšmę");
            System.out.println("4. ištrinti iš pozicijos");
            System.out.println("5. ieškoti");
            System.out.println("6. rusiuoti");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:// SARASAS PILDOMAS
                    fillLinkedList(list, reader);
                    break;
                case 2: // ITERPIMAS PAPILDOMAS. ITERPIMAS I PRADZIA
                    insertAtStart(scan, list);
                    break;
                case 3: // ITERPIMAS PAGRINDINIS, ITERPIMAS PAGAL REIKŠMĘ
                    insertAt(scan, list, writer);
                    break;
                case 4: // Salinimas is pozicijos
                    deleteFromPosition(scan, list, writer);
                    list.display();
                    break;
                case 5: // Paieska pagal varda
                    searchByName(scan, list, writer);

                    break;
                case 6: // Rusiavimas pagal numeri
                    sortByNumber(list, writer);
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            System.out.println("\nAr norite testi (t / n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'T' || ch == 't');

    }

    private static void sortByNumber(LinkedList list, Writer writer) {
        System.out.println("Rusiuojama \n ");
        list.sortListByNumber();
        try {
            writer.writeResultToFile(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.display();
    }

    private static void searchByName(Scanner scan, LinkedList list, Writer writer) {
        System.out.println("Iveskite vardą: ");
        String n = scan.next();
        String foundName = list.findAndReturnUser(n);
        if (foundName != null) {
            System.out.println(foundName + " buvo rastas");
            writer.writeResultToFile(foundName);
        } else {
            writer.writeResultToFile(n + " nebuvo rastas!");
            System.out.println(n + " nebuvo rastas!");
        }
    }

    private static void deleteFromPosition(Scanner scan, LinkedList list, Writer writer) {
        System.out.println("Enter position");
        int p = scan.nextInt();
        if (p < 1 || p > list.getSize())
            System.out.println("Invalid position\n");
        else
            list.deleteAtPosition(p);
        for (int i = 1; i < list.getSize(); i++) {
            writer.writeDataToPrimaryFile(list);
        }
    }

    private static void insertAt(Scanner scan, LinkedList list, Writer writer) {
        String name;
        Long number;
        Float percent;
        System.out.println("Iveskite vartotojo varda");
        name = scan.next();
        System.out.println("Iveskite vartotojo numerį");
        number = scan.nextLong();
        System.out.println("Iveskite palukanu normas");
        percent = scan.nextFloat();
        user = new User(name, number, percent);
        writer.appendDataToPrimaryFile(user);
        System.out.println("Iveskite pozicija i kuria norite ideti");
        int pos = scan.nextInt();
        if (pos < 1 || pos > list.getSize())
            System.out.println("Netinkama pozicija\n");
        else
            list.insertAtPos(user, pos);
    }

    private static void fillLinkedList(LinkedList list, Reader reader) {
        System.out.println("Pildomas masyvas....");

        if (reader.isMoreData) {
            reader.getUserData(list);
        }
        list.display();
    }

    private static void insertAtStart(Scanner scan, LinkedList list) {
        String name;
        Long number;
        Float percent;
        System.out.println("Iveskite vartotojo varda");
        name = scan.next();
        System.out.println("Iveskite vartotojo numerį");
        number = scan.nextLong();
        System.out.println("Iveskite palukanu normas");
        percent = scan.nextFloat();
        user = new User(name, number, percent);
        list.insertAtStart(user);
    }
}
