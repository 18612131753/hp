package com.yghsh.wx.util;

import java.io.IOException;  
import java.io.InputStream;  
import java.nio.charset.Charset;  
  
import ch.ethz.ssh2.Connection;  
import ch.ethz.ssh2.Session;

/** 
* 远程执行shell脚本类 
* @author wxl 
*/ 
public class RemoteShellTool {

    private Connection conn;  
    private String ipAddr;  
    private String charset = Charset.defaultCharset().toString();  
    private String userName;  
    private String password;
    
    /** 
     * @param args 
     */  
    public static void main(String[] args) {
  
        RemoteShellTool tool = new RemoteShellTool("123.57.173.154", "root",  
                "6upJwine", "utf-8");
        String result = tool.exec("sh /data/app/test.sh 12");
        System.out.print(result);
    }  
  
    public RemoteShellTool(String ipAddr, String userName, String password,  
            String charset) {
        this.ipAddr = ipAddr;  
        this.userName = userName;  
        this.password = password;  
        if (charset != null) {  
            this.charset = charset;  
        }  
    }  
  
    public boolean login() throws IOException {  
        conn = new Connection(ipAddr);  
        conn.connect(); // 连接  
        return conn.authenticateWithPassword(userName, password); // 认证  
    }  
  
    public String exec(String cmds) {
    	String result = "";
    	try {
            if (this.login()) {
                Session session = conn.openSession(); // 打开一个会话  
                session.execCommand(cmds);
                //读取结果
                //InputStream in = session.getStdout();  
                //result = this.processStdout( in );  
                session.close();  
                conn.close();
            }  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
        return result;  
    }  
  
    public String processStdout( InputStream in ) {
        byte[] buf = new byte[1024];  
        StringBuffer sb = new StringBuffer();  
        try { 
            while (in.read(buf) != -1) {  
                sb.append(new String(buf, this.charset));  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sb.toString();  
    } 
} 