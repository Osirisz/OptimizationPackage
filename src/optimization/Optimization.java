package optimization;

import java.util.*;
public class Optimization {
    public static void main(String[] args) {
        int modeIntensive = 0; //0=cpu, 1=memory
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert cpu(core): ");
        int cpu = sc.nextInt();
        System.out.println("Insert memory(GB): ");
        int memory = sc.nextInt();
        System.out.println("Mode intensive(0 = CPU intensive, 1 = Memory Intensive): ");
        modeIntensive = sc.nextInt();
        while(modeIntensive!=0 && modeIntensive!=1){
            System.out.println("Please input 0 or 1 only.");
            modeIntensive = sc.nextInt();
        }        
        ArrayList<Integer> arrayPreCheckResource = new ArrayList<Integer>(); //เก็บintก่อนไปcheck
        ArrayList<String> arrayPostCheckResource = new ArrayList<String>(); //เก็บstringคู่ที่checkแล้ว
        double packageMemory[] = new double[]{0.5,1,2,4,8,16,32,48,64,16,32,64,128,224};
        double packageCpu[] = new double[]{1,1,2,2,4,8,12,16,20,2,4,8,16,32,};
        double packageCost[] = new double[]{5,10,20,40,80,160,320,480,640,120,240,480,960,1680};
        double totalCostPackage;
        String newCheapIndex;
        int cheapIndex = -1;
        int lengthLastPackage;
        String lastPackage;
        int positionPackage;
        String orderPackage;
        double costLastPackage;
        String finalPackage = "";
        String firstPackage;
        int lengthFirstPackage;
        double resourcePackage;
        double finalResource = 0;
       
        //1vm
        for (int i = 0; i < packageCpu.length; i++) {
            if((packageMemory[i]-0.3)>=memory && packageCpu[i]>=cpu){
                if(cheapIndex == -1){
                    cheapIndex = i+1;
                }
                break;
            }
        }
        arrayPostCheckResource.add(cheapIndex+"");
//        2vm1
        while(arrayPreCheckResource.isEmpty()){ //checkว่าถ้าว่างให้เข้ามาทำ
            for (int i = 1; i < cheapIndex; i++) { //loop add 1-cheapIndex-1(ตัวก่อนสุดท้าย)เข้ามาเพื่อcheck
                arrayPreCheckResource.add(i); //addเลข1-cheapIndex-1(ตัวก่อนสุดท้าย)
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
                    System.out.println("CPU : " + packageCpu[firstValue-1]+" "+packageCpu[secondValue-1]);
                    System.out.println("Memory : " + packageMemory[firstValue-1]+" "+packageMemory[secondValue-1]);
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
                    if(((packageMemory[firstValue-1]+packageMemory[secondValue-1])-0.6)>=memory && (packageCpu[firstValue-1]+packageCpu[secondValue-1])>=cpu){ //เลือกคู่ที่จะไปadd
                        totalCostPackage = packageCost[firstValue-1]+packageCost[secondValue-1];
                        lengthLastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size() - 1).length();
                        lastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size() - 1);
                        costLastPackage = 0;
                        for (int i = 0; i < lengthLastPackage; i++) {
                            orderPackage = lastPackage.substring(i, i + 1);
                            positionPackage = Integer.parseInt(orderPackage);
                            costLastPackage += packageCost[positionPackage - 1];
                        }
                        if (totalCostPackage <= costLastPackage) {
                            if (lengthLastPackage==1) {
                                arrayPostCheckResource.remove(0);
                            }
                            newCheapIndex = firstValue + "" + secondValue;
                            arrayPostCheckResource.add(newCheapIndex);
                        }
                    }
                }                
            }
            break;
        }
        
        //3vm
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
                        totalCostPackage = packageCost[firstValue-1]+packageCost[secondValue-1]+packageCost[thirdValue-1];
                        lengthLastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size()-1).length();
                        lastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size()-1);
                        costLastPackage = 0;
                        for (int i = 0; i < lengthLastPackage; i++) {
                            orderPackage = lastPackage.substring(i, i + 1);
                            positionPackage = Integer.parseInt(orderPackage);
                            costLastPackage += packageCost[positionPackage - 1];
                        }
                        if(totalCostPackage <= costLastPackage){
                            newCheapIndex = firstValue+""+secondValue+""+thirdValue;
                            arrayPostCheckResource.add(newCheapIndex);
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
                            if (((packageMemory[firstValue - 1] + packageMemory[secondValue - 1] + packageMemory[thirdValue - 1]) - 0.9) >= memory && (packageCpu[firstValue - 1] + packageCpu[secondValue - 1] + packageCpu[thirdValue - 1]) >= cpu) {
                                totalCostPackage = packageCost[firstValue - 1] + packageCost[secondValue - 1] + packageCost[thirdValue - 1];
                                lengthLastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size() - 1).length();
                                lastPackage = arrayPostCheckResource.get(arrayPostCheckResource.size() - 1);
                                costLastPackage = 0;
                                for (int i = 0; i < lengthLastPackage; i++) {
                                    orderPackage = lastPackage.substring(i, i + 1);
                                    positionPackage = Integer.parseInt(orderPackage);
                                    costLastPackage += packageCost[positionPackage - 1];
                                }
                                if (totalCostPackage <= costLastPackage) {
                                    newCheapIndex = firstValue + "" + secondValue + "" + thirdValue;
                                    arrayPostCheckResource.add(newCheapIndex);
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
        
        //check number of package
        if(arrayPostCheckResource.size()==1){
            finalPackage = arrayPostCheckResource.get(0);
        }
        else {
            if(modeIntensive == 0 ){ //cpu
                while(!arrayPostCheckResource.isEmpty()){
                    System.out.println("---------------------------------");
                    lengthFirstPackage = arrayPostCheckResource.get(0).length();
                    firstPackage = arrayPostCheckResource.get(0);
                    resourcePackage = 0;
                    for (int i = 0; i < lengthFirstPackage; i++) {
                        orderPackage = firstPackage.substring(i, i + 1);
                        positionPackage = Integer.parseInt(orderPackage);
                        resourcePackage += packageCpu[positionPackage - 1];
                    }

                    if (finalResource == 0) {
                        finalResource = resourcePackage;
                        finalPackage = firstPackage;
                    }
                    else {
                        if (finalResource<resourcePackage) {
                            finalResource = resourcePackage;
                            finalPackage = firstPackage;
                        }
                    }
                    arrayPostCheckResource.remove(0);
                }                
            }
            else{
                while(!arrayPostCheckResource.isEmpty()){
                    lengthFirstPackage = arrayPostCheckResource.get(0).length();
                    firstPackage = arrayPostCheckResource.get(0);
                    resourcePackage = 0;
                    for (int i = 0; i < lengthFirstPackage; i++) {
                        orderPackage = firstPackage.substring(i, i + 1);
                        positionPackage = Integer.parseInt(orderPackage);
                        resourcePackage += packageMemory[positionPackage - 1];
                    }

                    if (finalResource == 0) {
                        finalResource = resourcePackage;
                        finalPackage = firstPackage;
                    }
                    else {
                        if (finalResource<resourcePackage) {
                            finalResource = resourcePackage;
                            finalPackage = firstPackage;
                        }
                    }
                    arrayPostCheckResource.remove(0);
                }  
            }
        }
        
        System.out.println("Cheap : " + cheapIndex);
        System.out.println("CPU : " + packageCpu[cheapIndex-1]);
        System.out.println("Memory : " + packageMemory[cheapIndex-1]);
        System.out.println("Cost : " + packageCost[cheapIndex-1]); 
        System.out.println("List Package : " + arrayPostCheckResource);
        System.out.println("Final package : "+finalPackage);
    }
    
}
