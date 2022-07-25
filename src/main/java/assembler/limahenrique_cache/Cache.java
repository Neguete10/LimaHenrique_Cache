/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assembler.limahenrique_cache;
/**
 *
 * @author Henri
 */

import java.util.Scanner; 

public class Cache {
    
    public static void main(String[] args) {
        
        
        //MEMORY        
        String[] binary = new String[64];
        String data[] = {"92","70","8C","FD","B9","E2","40","C2","0D","9A","D1","F8","43","7E","B7","75","FB","44","DD","F6","A6","43","11","17","98","88","08","6A","6D","B8","BC","12","0A","F1","4C","45","63","2C","40","98","91","65","0E","76","EE","5D","18","29","85","13","60","C5","56","F2","89","9E","06","E2","0B","A2","B2","41","B1","7B"};
          
        for(int i =0; i<64;i++){ 
            
            binary[i] = Integer.toBinaryString(i);          
        
            if(binary[i].length()!= 6 ){         
                int size = binary[i].length();
                while(size != 6){
                    binary[i] = '0'+ binary[i]; 
                    size++;
                }           
            }
        }
        
        //CACHE DISPLAY
        
        String format = "\t%-10s%-10s%-10s%-10s%n";
        String format1 = "%-10s%-10s%-10s%-10s%-10s%n";
        System.out.printf(format,"TAG","DATA","TAG","DATA");
        System.out.printf(format1,"SET 0", "-", "-", "-", "-");
        System.out.printf(format1,"SET 1", "-", "-", "-", "-");
        System.out.printf(format1,"SET 2", "-", "-", "-", "-");
        System.out.printf(format1,"SET 3", "-", "-", "-", "-");        
        System.out.println();
        
        //Cache data
        String tagCache[][] = new String[4][2];
        String dataCache[][] = new String[4][2];
        int keyCache[][] = new int[4][2];
        
        for(int i = 0; i < 4 ; i++){
           for(int j = 0; j < 2; j++){
           
               keyCache[i][j] = 0;
               tagCache[i][j] = "-";
               dataCache[i][j] = "-";
           
           }      
       }
        
        
        
        while(true){
        //USER INPUT       
        
        System.out.println("Type in memory address (0,63)");        
        Scanner input = new Scanner(System.in);
        String stop = input.nextLine();
        if(stop.equals("exit")){        
            System.exit(0);
        }
        int memoryAdr = Integer.parseInt(stop);
        
        //User input validation
        while(!((memoryAdr >= 0) && (memoryAdr <=63))){
        
            System.out.println("ERROR - Type in memory address (0,63)"); 
            stop = input.nextLine();
            if(stop.equals("exit")){        
                System.exit(0);
            }
            memoryAdr = Integer.parseInt(stop);        
        }
        
        // Retrieve data from Memory
        String tag = binary[memoryAdr].substring(0, 4);
        String set = binary[memoryAdr].substring(4,6);
        String Data = data[memoryAdr]; 
        
        
        switch(set){
            
            case "00" -> {
                if(tag.equals(tagCache[0][0]) || (tag.equals(tagCache[0][1]))){
                    System.out.println("HIT! TAG: " + tag + "\t" + "DATA: " + data[memoryAdr]);
                }
                else{
                    
                    System.out.println("MISS! TAG: " + tag + "\t" +"DATA: " + data[memoryAdr]);
                
                    if(keyCache[0][0] == 0){                    
                        tagCache[0][0] = tag;
                        dataCache[0][0] = Data;
                        keyCache[0][0] = 1;
                        keyCache[0][1] = 0;
                    }
                    else{                       
                        tagCache[0][1] = tag;
                        dataCache[0][1] = Data;
                        keyCache[0][0] = 0;                        
                    }                  
                
                }
            }
            case "01" -> {
                if(tag.equals(tagCache[1][0]) || (tag.equals(tagCache[1][1]))){
                    System.out.println("HIT! TAG: " + tag + "\t" + "DATA: " + data[memoryAdr]);
                }
                else{
                    
                    System.out.println("MISS! TAG: " + tag + "\t" +"DATA: " + data[memoryAdr]);
                
                    if(keyCache[1][0] == 0){                    
                        tagCache[1][0] = tag;
                        dataCache[1][0] = Data;
                        keyCache[1][0] = 1;
                        keyCache[1][1] = 0;
                    }
                    else{                       
                        tagCache[1][1] = tag;
                        dataCache[1][1] = Data;
                        keyCache[1][0] = 0;                        
                    }                  
                
                }
            }
            case "10" -> {
                if(tag.equals(tagCache[2][0]) || (tag.equals(tagCache[2][1]))){
                    System.out.println("HIT! TAG: " + tag + "\t" + "DATA: " + data[memoryAdr]);
                }
                else{
                
                    System.out.println("MISS! TAG: " + tag + "\t" +"DATA: " + data[memoryAdr]);
                    
                    if(keyCache[2][0] == 0){                    
                        tagCache[2][0] = tag;
                        dataCache[2][0] = Data;
                        keyCache[2][0] = 1;
                        keyCache[2][1] = 0;
                    }
                    else{                       
                        tagCache[2][1] = tag;
                        dataCache[2][1] = Data;
                        keyCache[2][0] = 0;                        
                    }                  
                
                }
            }
                
            case "11" -> {
                if(tag.equals(tagCache[3][0]) || (tag.equals(tagCache[3][1]))){
                    System.out.println("HIT! TAG: " + tag + "\t" +"DATA: " + data[memoryAdr]);
                }
                else{                
                    
                    System.out.println("MISS! TAG: " + tag + "\t" +"DATA: " + data[memoryAdr]);
                    
                    if(keyCache[3][0] == 0){                    
                        tagCache[3][0] = tag;
                        dataCache[3][0] = Data;
                        keyCache[3][0] = 1;
                        keyCache[3][1] = 0;
                    }
                    else{                       
                        tagCache[3][1] = tag;
                        dataCache[3][1] = Data;
                        keyCache[3][0] = 0;                        
                    }                  
                
                }
            }
             
           }
        
        //DISPLAY UPDATED CACHE
        
        System.out.printf(format,"TAG","DATA","TAG","DATA");
        System.out.printf(format1,"SET 0", tagCache[0][0], dataCache[0][0] ,tagCache[0][1], dataCache[0][1]);
        System.out.printf(format1,"SET 1", tagCache[1][0], dataCache[1][0] ,tagCache[1][1], dataCache[1][1]);
        System.out.printf(format1,"SET 2", tagCache[2][0], dataCache[2][0] ,tagCache[2][1], dataCache[2][1]);
        System.out.printf(format1,"SET 3", tagCache[3][0], dataCache[3][0] ,tagCache[3][1], dataCache[3][1]);        
        System.out.println();
        
        }
        
        
        
    
    }

}
