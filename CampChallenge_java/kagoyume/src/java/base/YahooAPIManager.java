/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javaBeans.ItemDataBeans;

/**
 *
 * @author Y.Sasa
 */
public class YahooAPIManager {
    
    private static final String JSONP="http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    private static final String APP_ID="dj0zaiZpPTRaQ2h0UlFEWktaTiZzPWNvbnN1bWVyc2VjcmV0Jng9N2I-";
    private static int totalResultNum;
    
    public static ArrayList<ItemDataBeans> ParseJSON(String Json)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode rootNode=mapper.readTree(Json);
        
        ArrayList<ItemDataBeans> items=new ArrayList<ItemDataBeans>();
        
        JsonNode resultSetNode=rootNode.get("ResultSet");
        totalResultNum=Integer.parseInt(resultSetNode.get("totalResultsAvailable").asText());
        int resultReturned=resultSetNode.get("totalResultsReturned").asInt();
        
        if(getTotalResultNum()==0){
            return items;
        }
        JsonNode resultNode=resultSetNode.get("0").get("Result");
        for(int i=0;i<resultReturned;i++){
            JsonNode itemNumNode=resultNode.get(String.valueOf(i));
            ItemDataBeans idb=new ItemDataBeans();
            idb.setItemName(itemNumNode.get("Name").asText());
            idb.setItemDescription(itemNumNode.get("Description").asText());
            idb.setItemImage(itemNumNode.get("Image").get("Medium").asText());
            idb.setItemPrice(itemNumNode.get("Price").get("_value").asText());
            idb.setItemCode(itemNumNode.get("Code").asText());
            items.add(idb);
        }
        return items;
    }
    
    //命名規則はあっているか？
    public static String getJson(String searchPhrase)throws Exception{
        //Yahooに送信する情報
        URL url=new URL(JSONP+"?appid="+APP_ID+"&query="+searchPhrase+"&hits=20");
        
        //Http通信の設定と開始
        HttpURLConnection urlcon=(HttpURLConnection)url.openConnection();
        urlcon.setRequestMethod("GET");
        //要調査
        urlcon.setInstanceFollowRedirects(false);
        urlcon.connect();
        //Yahooから情報を受け取る
        BufferedReader buffer=new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        StringBuffer responseBuffer=new StringBuffer();
        while(true){
            String line=buffer.readLine();
            if(line==null){
                break;
            }
            responseBuffer.append(line);
        }
        //close
        buffer.close();
        urlcon.disconnect();
        //jsonを返す
        return responseBuffer.toString();
        
    }

    public static int getTotalResultNum() {
        return totalResultNum;
    }

}
