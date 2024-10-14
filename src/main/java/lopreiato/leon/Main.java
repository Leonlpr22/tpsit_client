package lopreiato.leon;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client in avvio!");
        
        Socket s = new Socket("localhost", 5637);
        System.out.println("Il client si è collegato");


        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaInviata;
        String stringaRicevuta;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Inserire una stringa per terminare l'esecuzione");
            stringaInviata = scanner.nextLine();
            out.writeBytes(stringaInviata +"\n");
            stringaRicevuta = in.readLine();
        } while (stringaInviata.equals("0"));



        out.writeBytes("sono il Client" + "\n");

        System.out.println("La stringa ricevuta: " + stringaRicevuta);

        s.close();






    }
}