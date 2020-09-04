package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.List;

public class HttpPostRequest {

    private Socket socket;

    private String path;

    private String host;

    public HttpPostRequest(String url){
        try {
            URL u = new URL(url);
            this.path = u.getPath();
            this.host = u.getHost();
            //System.out.println(u.getHost()+" "+u.getPath());
            socket = new Socket(u.getHost(),80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String send(List<Double> list){
        try {
            String li = list.toString();
            //System.out.println("POST "+path+" HTTP/1.1");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("POST "+path+" HTTP/1.1");
            out.println("Host: "+host);
            out.println("Content-Type: application/json");
            //out.println();
            out.println("Content-Length:"+li.getBytes().length);
            out.println();
            out.println(li);
            String line;
            String resp = "";
            while ((line=in.readLine()).length()>0) resp = resp+line+"\n";
            //System.out.println(resp);
            StringBuilder build = new StringBuilder();
            while (in.ready()) build.append((char) in.read());
            //System.out.println(build);
            in.close();
            out.close();
            socket.close();
            return build.toString();


        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

}
