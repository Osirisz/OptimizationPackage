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
public class Match3pair {
    public static void main(String[] args) {
        int cheapIndex = 5;
        ArrayList<Integer> arrayPreCheckResource = new ArrayList<Integer>(); //เก็บintก่อนไปcheck
        ArrayList<String> arrayPostCheckResource = new ArrayList<String>(); //เก็บstringคู่ที่checkแล้ว
        arrayPostCheckResource.add(cheapIndex+"");
        double packageMemory[] = new double[]{0.5,1,2,4,8,16,32,48,64,16,32,64,128,224};
        double packageCpu[] = new double[]{1,1,2,2,4,8,12,16,20,2,4,8,16,32,};
        double packageCost[] = new double[]{5,10,20,40,80,160,320,480,640,120,240,480,960,1680};
        double cpu = 2;
        double memory = 4;
        double totalCostPackage;
        int lengthLastPackage;
        String lastPackage;
        int positionPackage;
        String orderPackage;
        double costLastPackage;
        String newCheapIndex;
        while(arrayPreCheckResource.isEmpty()){ //checkว่าถ้าว่างให้เข้ามาทำ
            for (int i = 1; i < cheapIndex; i++) { //loop add 1-cheapIndex-1(ตัวก่อนสุดท้าย)เข้ามาเพื่อcheck
                arrayPreCheckResource.add(i); //addเลข1-cheapIndex-1(ตัวก่อนสุดท้าย)
            }
            while(!arrayPreCheckResource.isEmpty()){ //เมื่อมีข้อมูลจึงเข้ามาทำ
                int firstValue = arrayPreCheckResource.get(0);
                int secondValue = arrayPreCheckResource.get(0);
                int thirdValue = arrayPreCheckResource.get(0);
                
                System.out.println(arrayPreCheckResource.size()-1); //3
                for (int j = 1; j <= arrayPreCheckResource.size(); j++) { //1-4
                    System.out.println("j"+j);
                    thirdValue = arrayPreCheckResource.get(j-1);
                    System.out.println("sec"+secondValue); //value1-4
                    System.out.println("third"+thirdValue);
                    System.out.println("pack"+firstValue+""+secondValue+""+thirdValue); //packageที่มี
                    System.out.println("CPU : " + packageCpu[firstValue-1]+" "+packageCpu[secondValue-1]+" "+packageCpu[thirdValue-1]);
                    System.out.println("Memory : " + packageMemory[firstValue-1]+" "+packageMemory[secondValue-1]+" "+packageMemory[thirdValue-1]);
                    System.out.println("size"+arrayPreCheckResource.size()); //size
                    System.out.println(j+"=="+(arrayPreCheckResource.size())); //ไล่ค่าแต่ละครั้ง
                    
                    if(((packageMemory[firstValue-1]+packageMemory[secondValue-1]+packageMemory[thirdValue-1])-0.9)>=memory && (packageCpu[firstValue-1]+packageCpu[secondValue-1]+packageCpu[thirdValue-1])>=cpu){
                        System.out.println("*****************************************");
                        totalCostPackage = packageCost[firstValue-1]+packageCost[secondValue-1]+packageCost[thirdValue-1];
                        if(cheapIndex == -1){
                            cheapIndex = 0;
                        }
                        else if(totalCostPackage <= packageCost[cheapIndex-1]){
                            System.out.println("-----------------------------------------------");
                            System.out.println(firstValue+""+secondValue+""+thirdValue);
                            System.out.println(totalCostPackage);
                            lengthLastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size()-1).length();
                            lastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size()-1);
                            costLastPackage = 0;
                            for (int i = 0; i < lengthLastPackage; i++) {
                                orderPackage = lastPackage.substring(i, i + 1);
                                positionPackage = Integer.parseInt(orderPackage);
                                costLastPackage += packageCost[positionPackage - 1];
                            }
                            if(totalCostPackage<=costLastPackage){
                                System.out.println("Add");
                                newCheapIndex = firstValue+""+secondValue+""+thirdValue;
                                arrayPostCheckResource.add(newCheapIndex);
                            }
                        }

                    }
                    
                    if(arrayPreCheckResource.size()==1){ //ถ้าในarrayเหลือตัวสุดท้ายให้หยุด
                        System.out.println("stop");
                        arrayPreCheckResource.clear(); //clearทุกค่าออกให้หลุดloop
                    }
                    if(j==arrayPreCheckResource.size()) { //ถ้าถึงรอบที่วนจับคู่ตัวเดียวกับก็removeตัวแรกออก
                        for (int k = 2; k <= arrayPreCheckResource.size(); k++) {
                            secondValue = arrayPreCheckResource.get(k-1);
                            System.out.println("pack"+firstValue+""+secondValue+""+thirdValue);
                            System.out.println("second"+secondValue);
                            System.out.println("size"+arrayPreCheckResource.size());
                            System.out.println(arrayPreCheckResource);
                            if (((packageMemory[firstValue - 1] + packageMemory[secondValue - 1] + packageMemory[thirdValue] - 1) - 0.9) >= memory && (packageCpu[firstValue - 1] + packageCpu[secondValue - 1] + packageCpu[thirdValue - 1]) >= cpu) { //เลือกคู่ที่จะไปadd
                                System.out.println("*****************************************");
                                totalCostPackage = packageCost[firstValue - 1] + packageCost[secondValue - 1] + packageCost[thirdValue - 1];
                                if (cheapIndex == -1) {
                                    cheapIndex = 0;
                                } 
                                else if (totalCostPackage <= packageCost[cheapIndex - 1]) {
                                    System.out.println("-----------------------------------------------");
                                    System.out.println(firstValue + "" + secondValue + "" + thirdValue);
                                    System.out.println(totalCostPackage);
                                    lengthLastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size() - 1).length();
                                    lastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size() - 1);
                                    costLastPackage = 0;
                                    for (int i = 0; i < lengthLastPackage; i++) {
                                        orderPackage = lastPackage.substring(i, i + 1);
                                        positionPackage = Integer.parseInt(orderPackage);
                                        costLastPackage += packageCost[positionPackage - 1];
                                    }
                                    if (totalCostPackage <= costLastPackage) {
                                        System.out.println("Add");
                                        newCheapIndex = firstValue + "" + secondValue + "" + thirdValue;
                                        arrayPostCheckResource.add(newCheapIndex);
                                    }
                                }
                            }
                        }
                        
                        if (!arrayPreCheckResource.isEmpty() && secondValue == cheapIndex-1) {
                            System.out.println("remove");
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
        System.out.println(arrayPostCheckResource);
    }
}
