import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException, IOException {
        Socket client = new Socket("google.com", 80);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();
        String request = "GET / HTTP/1.1\r\nHOST:www.google.com\r\n\r\n";
        outputStream.write(request.getBytes());
        outputStream.flush();
//        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
//        String result = s.hasNext() ? s.next() : "";
//        System.out.println(result);
//        System.out.println("------------------------");
//        StringWriter writer = new StringWriter();
//        IOUtils.copy(inputStream,writer,"UTF-8");
//        String str = writer.toString();
//        System.out.println(str);
//        System.out.println("------------------------");
        String line = IOUtils.toString(inputStream,StandardCharsets.UTF_8);
        String[] lineArray = line.split("\\r\\n\\r\\n");
        String status = lineArray[0].split("\r\n")[0].split(" ")[1];
        String reason = lineArray[0].split("\r\n")[0].split(" ")[2];
        String headers = lineArray[0].split("\r\n",2)[1];
        HttpResponseClass response = new HttpResponseClass(status,reason,headers,lineArray[1]);
        client.close();
    }
}
