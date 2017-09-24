/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimization;

import java.util.*;

/**
 *
 * @author EARTH
 */
public class test {
    public static void main(String[] args) {
        int cheapIndex = 5;
        ArrayList<Integer> arrayPreCheckResource = new ArrayList<Integer>(); //เก็บintก่อนไปcheck
        ArrayList<String> arrayPostCheckResource = new ArrayList<String>(); //เก็บstringคู่ที่checkแล้ว
        while(arrayPreCheckResource.isEmpty()){ //checkว่าถ้าว่างให้เข้ามาทำ
            for (int i = 1; i <= cheapIndex-1; i++) { //loop add 1-cheapIndexเข้ามาเพื่อcheck
                arrayPreCheckResource.add(i); //addเลข1-cheapIndex
            }
            while(!arrayPreCheckResource.isEmpty()){ //เมื่อมีข้อมูลจึงเข้ามาทำ
                int firstValue = arrayPreCheckResource.get(0);
                int secondValue = arrayPreCheckResource.get(0);
                
                System.out.println(arrayPreCheckResource.size()-1); //3
                for (int j = 1; j <= arrayPreCheckResource.size(); j++) { //1-4
                    System.out.println("j"+j);
                    secondValue = arrayPreCheckResource.get(j-1);//ขยับไปอีกช่อง ช่อง0-3
                    System.out.println("sec"+secondValue); //value1-4
                    System.out.println("pack"+firstValue+""+secondValue); //packageที่มี
                    System.out.println("size"+arrayPreCheckResource.size()); //size
                    System.out.println(j+"=="+(arrayPreCheckResource.size())); //ไล่ค่าแต่ละครั้ง
                    
                    if(arrayPreCheckResource.size()==1){ //ถ้าในarrayเหลือตัวสุดท้ายให้หยุด
                        System.out.println("stop");
                        arrayPreCheckResource.clear(); //clearทุกค่าออกให้หลุดloop
                    }
                    if(j==arrayPreCheckResource.size()) { //ถ้าถึงรอบที่วนจับคู่ตัวเดียวกับก็removeตัวแรกออก
                        System.out.println("remove");
                        if (!arrayPreCheckResource.isEmpty()) {
                            arrayPreCheckResource.remove(0);
                            System.out.println("sizeAR"+arrayPreCheckResource.size());
                            System.out.println(arrayPreCheckResource);
                            System.out.println();
                        }                       
                    }                    
                }                
            }
            break;
        }
        System.out.println("end");
    }
}
