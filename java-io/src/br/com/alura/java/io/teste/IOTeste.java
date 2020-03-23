package br.com.alura.java.io.teste;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class IOTeste {

    public static void main(String[] args) throws IOException {
//        input();
//        readAllLinesFor();
//        readAllLinesWhile();
        scanFile();
    }

    public static void input() throws IOException {
//        Versao da alura
//        FileInputStream fis = new FileInputStream("lorem.txt");
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(isr);
//        String linha = br.readLine();
//        System.out.println(linha);

//        Versao do lorde supremo
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\PC\\Desktop\\Projeto Compasso\\Pesquisas Sprint 1\\LGPD.txt"));
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream("../../Pesquisas Sprint 1/LGPD.txt"));
        BufferedReader buffer = new BufferedReader(inputStream);
        System.out.println(buffer.readLine());
        buffer.close();
    }

    public static void readAllLinesWhile() throws IOException {
//      Versao do lorde supremo
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream("../../Pesquisas Sprint 1/LGPD.txt"));
        BufferedReader buffer = new BufferedReader(inputStream);
        String line = buffer.readLine();

        while (line != null){
            System.out.println(line);
            line = buffer.readLine();
        }
        buffer.close();
    }

    public static void readAllLinesFor() throws IOException {
//      Versao do lorde supremo
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream("../../Pesquisas Sprint 1/LGPD.txt"));
        BufferedReader buffer = new BufferedReader(inputStream);

        for (String lines = buffer.readLine(); lines != null; lines = buffer.readLine()) {
            System.out.println(lines);
        }

        buffer.close();
    }

    public static void scanFile() throws IOException {
//      Versao do lorde supremo
        Scanner file = new Scanner(new File("../../Pesquisas Sprint 1/LGPD.txt"));
        while (file.hasNextLine()) System.out.println(file.nextLine());
        file.close();
    }
}