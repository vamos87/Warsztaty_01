package Zadanie_05;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){

        Connection connect = Jsoup.connect("http://www.onet.pl");
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for(Element elem : links) {
                //System.out.println(elem.text());
                String[] lines = elem.text()
                        .replace(".","")
                        .replace(",","")
                        .replace("!","")
                        .replace("?","")
                        .replace("-","")
                        .replace(":","")
                        .replace("”","")
                        .replace("\"","")
                        .replace("\n","")
                        .toLowerCase()
                        .split(" ");
                for(String word : lines){
                    if(word.length()>=3){
                        arrayList.add(word);
                    }
                    //System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get("popular_words.txt");
        try {
            Files.write(path,arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] removedWords = {"oraz","ponieważ","jeżeli","gdyż","lecz","który"};
        ArrayList<String> filtered = new ArrayList<>();
        try {
            for(String line : Files.readAllLines(path)){
                int count = 0;
                for(int i=0; i<removedWords.length; i++){
                    if (!removedWords[i].equals(line)){
                        count++;
                    }
                }
                if(count == removedWords.length){
                    filtered.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathFiltered = Paths.get("filtered_popular_words.txt");
        try {
            Files.write(pathFiltered,filtered);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
