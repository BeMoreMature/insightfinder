import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class readMessage {
    static String directoryPath = "./data";     //directory path, all the files under the data folder
    static List<Log> logs = new ArrayList<>();  //record the logs
    static int index = 1;                       //record the number of logs
    /*
        This function is used to read all the messages line by line in the data folder
        Output all the messages
     */
    public static void readMessage(){
        System.out.println("All the messages in the input files are as followed: ");
        File dir = new File(directoryPath);
        File[] fileList = dir.listFiles();
        if(fileList != null){
            for(File file : fileList){
                System.out.println("File "+file);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "utf-8"), 5 * 1024 * 1024);
                    String line = "";
                    while((line = bufferedReader.readLine()) != null){
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    bufferedInputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
        First step in this function is getting the input word
        Second step is iterate all the messages
        Third step, if we find the matched word, convert word to uppercase and print, at the same time, keep the search information into logs
     */
    public static void findWords(){
        Scanner scanner = new Scanner(System.in);
        String word = new String();
        while((word = scanner.nextLine()) != null){     //if input is not null and -1, do word search
            if(word.equals("-1")) break;
            Log log = new Log(index++, word,0);
            File dir = new File(directoryPath);
            File[] fileList = dir.listFiles();
            if(fileList != null) {
                for (File file : fileList) {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "utf-8"), 5 * 1024 * 1024);
                        String line = "";
                        while((line = bufferedReader.readLine()) != null){
                            if(line.contains(word)){
                                log.numberOfMatch++;        //count the number of matched words
                                String res = line.replace(word, word.toUpperCase());
                                System.out.println(res);
                            }
                        }
                        bufferedReader.close();
                        bufferedInputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            logs.add(log);
        }
    }
    /*
        print all the logs
     */
    public static void printLogs(){
        System.out.println("Total number of searches is "+logs.size());
        for(Log log : logs){
            System.out.println("Number "+log.index+" search word is "+log.info+", the number of matched words is "+log.numberOfMatch);
        }
    }
    public static void main(String args[]){
        readMessage();
        findWords();
        printLogs();
    }
}
class Log{
    int index;      // the index of log
    String info;        //the information of message
    int numberOfMatch;          // the number of matched words
    public Log(int index, String info, int numberOfMatch){
        this.index = index;
        this.info = info;
        this.numberOfMatch = numberOfMatch;
    }
}
