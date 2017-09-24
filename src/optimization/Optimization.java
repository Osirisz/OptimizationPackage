package optimization;

import java.util.*;
public class Optimization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert cpu(core): ");
        int cpu = sc.nextInt();
        System.out.println("Insert memory(GB): ");
        int memory = sc.nextInt();
        ArrayList<Integer> packageList = new ArrayList<Integer>();
        
        double packageMemory[] = new double[]{0.5,1,2,4,8,16,32,48,64,16,32,64,128,224};
        double packageCpu[] = new double[]{1,1,2,2,4,8,12,16,20,2,4,8,16,32,};
        double packageCost[] = new double[]{5,10,20,40,80,160,320,480,640,120,240,480,960,1680};
        int cheapIndex = -1;
        //1vm
        for (int i = 0; i < packageCpu.length; i++) {
            for (int j = 0; j < packageMemory.length; j++) {
                if((packageMemory[j]-0.3)>=(memory) && packageCpu[j]>=cpu){
                    if(cheapIndex == -1)
                        cheapIndex = j;
                    else if(packageCost[j] < packageCost[cheapIndex]){
                        cheapIndex = j;
                    }
                    break;
                }
            }  
        }
        //2vm++
        ArrayList<Integer> arrayMatchPackage = new ArrayList<Integer>();
        for (int i = 2; i <= cheapIndex; i++) {//จำนวนคู่
            for (int j = 1; j < cheapIndex; j++) { //add1ถึงน้อยกว่าchaepIndex(ก่อนตำแหน่งสุดท้าย)จะได้ลดจำนวนลงได้อีก
                arrayMatchPackage.add(j);
                while(true) { //จับคู่1ถึงน้อยกว่าcheapIndex(ก่อนตำแหน่งสุดท้าย)จะได้ลดจำนวนลงได้อีก
                    //จับคู่ถึงcheapแล้วเทียบresourceแล้วaddเข้าarray
                    //จับคุ่ยังไงให้มันครบ
                }
                //เอาarrayมาจับคู่ถึงn-1และpopตัวแรกออกไปเรื่อยๆ, ให้array={}
            }
        }
        
        System.out.println("array"+arrayMatchPackage);
        
        
        System.out.println("Cheap : " + cheapIndex);
        System.out.println("CPU : " + packageCpu[cheapIndex]);
        System.out.println("Memory : " + packageMemory[cheapIndex]);
        System.out.println("Cost : " + packageCost[cheapIndex]);       
    }
    
}
