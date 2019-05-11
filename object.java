import java.util.*;

public class object{
    int numoflist = 0;
    private class obtype{

        String tpname = "";
        String obname = "";
        String[] atrb = new String[5];
        String[] obatrb = new String[5];
        int numofatrb = 0;
        int numofname = 0;

    }
    private class allobjtype{

        obtype[] all = new obtype[10];
        int numoftype = 0;

    }
    private class sortobj{
        int[] indexofobj = new int[numoflist];
        String[] objforsort = new String[10];

    }
    public allobjtype create(){    

        allobjtype allobj = new allobjtype();
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            obtype obj = new obtype();
            String str ="";

            System.out.print("You can create up to 10 different objects.\r\n");

            System.out.print("Enter the object's type.(triangle,car...etc)\r\n");
            obj.tpname = scanner.next();

            System.out.print("Enter the attributes of this object.(only up to 5 defferent attributes)\r\nEnter 0 to quit.\r\n");


            while(obj.numofatrb<5){
                str = scanner.next();
                if(str.equals("0")){
                  break;
                }else if(obj.numofatrb>=5){
                  System.out.print("Reach the limit.");
                  break;
                }else{
                  obj.atrb[obj.numofatrb] = str;
                  obj.numofatrb++;
                }

               }

            allobj.all[allobj.numoftype] =  obj;
            allobj.numoftype++;

            if(allobj.numoftype<10){
                System.out.print("Create another object?\r\nyes/no\r\n");
                str = scanner.next();
                if(str.equals("yes")){       
                }else if(str.equals("no")){
                    break;
                }else{
                    System.out.print("ERROR");
                    break;
                }
            }else{
                System.out.print("Reach the limit\r\n");
                break;
            }

        }
        scanner.close();
        return allobj;
    }
    public obtype enter(obtype obj,allobjtype allobj){

        Scanner scanner = new Scanner(System.in);
        String str = "";
        int j = 0;
        int i = 0;
        System.out.print("Choose an object type.\r\n");
        while(i<allobj.numoftype){
            System.out.printf("%d.%s\r\n",i+1,allobj.all[i].tpname);
            i++;
        }
        j = scanner.nextInt();
        i = 0;
        j--;
        obj.tpname = allobj.all[j].tpname;
        obj.numofname = j;
        for(int x = 0;x < allobj.all[j].numofatrb;x++){
          obj.atrb[x] = allobj.all[j].atrb[x];
          obj.numofatrb = allobj.all[j].numofatrb;     
        }
        System.out.print("Enter the name of object\r\n");
        str = scanner.next();
        obj.obname = str;

        System.out.print("Complete the attributes of object\r\n");
        while(i<obj.numofatrb){
            System.out.print(obj.atrb[i]+":");
            str = scanner.next();
            obj.obatrb[i] = str;
           
            i++;
        }
        scanner.close();
        return obj;

    }



public String[] RemoveNullValue(String[] sysName) {

    List<String> list = new ArrayList<String>();

    for(String s : sysName) {
       if(s != null && s.length() > 0) {
          list.add(s);
       }
    }

    sysName = list.toArray(new String[list.size()]);
  return  sysName ;
}


    public void sort(obtype[] objlist,allobjtype allobj){
        Scanner scanner = new Scanner(System.in);
        sortobj sortobj1 = new sortobj();
        sort2 sort2 =new sort2();
      while(true){
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;
        int n2 = 0;
    
        System.out.print("Choose an object type to sort\r\n");
        while(i<allobj.numoftype){
            System.out.printf("%d:%s\r\n" , i +1 ,allobj.all[i].tpname);
            i++;
        }

        j = scanner.nextInt();
        j--;

        for(x = 0;x<numoflist;x++){
            if(objlist[x].numofname == j){
                sortobj1.indexofobj[y]=x;
                y++;
            }
        }
        System.out.print("Choose an object attribute to sort\r\n");
        for(int a1 = 0;a1<objlist[sortobj1.indexofobj[0]].numofatrb;a1++){
            System.out.print(a1+1);
            System.out.print(":"+objlist[sortobj1.indexofobj[0]].atrb[a1]+"\r\n");
        }
        n2 = scanner.nextInt();
        n2--;
        for(int aa = 0;aa<y;aa++){
            sortobj1.objforsort[aa] = objlist[sortobj1.indexofobj[aa]].obatrb[n2];
        }
        sort2.sort(RemoveNullValue(sortobj1.objforsort),1,1);        
        
         System.out.print(allobj.all[j]+"\r\n");
          System.out.print("sort other ?\r\n");
        String stri =scanner.next();
        if(stri.equals("yes")){
          
        }
        else{
          break;
        } 
        }
        scanner.close();
        }
       
        
    
    public void syst(){  
        Scanner scanner = new Scanner(System.in);
        String str = ""; 
        allobjtype allobj = new allobjtype();
        obtype[] objlist = new obtype[10]; 
      
        allobj = create();

        
        while(true){

            obtype obj = new obtype();
            System.out.print("Do you want to complete the data of an object?\nyes/no\n");
            str = scanner.next();

            if(str.equals("yes")){
                if(numoflist<10){
                    objlist[numoflist] = enter(obj,allobj);
                    numoflist++;
                }else{
                    System.out.print("Reach the limits(10/10  object)\r\n");
                    break;
                }              
            }else{

                sort(objlist,allobj);
                System.exit(0);
            }
        }
        scanner.close();
        sort(objlist,allobj);
        
    }
  
}