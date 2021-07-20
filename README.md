formatter: sql formatter

caller: java caller: 最大问题在查找调用者的接口实现类



import aa.bb.cc.Test123;
public class HelloWorld {                     
private String aa;                         
private Test123 bb;                        
private String mm() {                      
return aa;                             
}                                          
public static void main(String[] args) {   
System.out.println(Test456.xx());   
HelloWorld hw = new HelloWorld();       
hw.aa = "ffffff";                     
System.out.println(bb.mm());           
}                                          
}                