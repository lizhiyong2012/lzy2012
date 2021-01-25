import java.lang.reflect.Field;
public class HelloWorld{
	public static void main(String[] args) throws Exception{
		String a = "ABCabc";
		System.out.println("a = " + a);
		a = a.replace('A', 'a');
		System.out.println("a = " + a);
		//Java中的String对象不可变
		String ss = "123456";
		System.out.println("ss = " + ss);
		ss.replace('1', '0');
		//修正
		//ss=ss.replace('1', '0');
		//ss的值没有发生变化
		System.out.println("ss = " + ss);
		
        //通过反射修改 
		String s = "Hello World";      
		System.out.println("s = " + s); //Hello World  
		Field valueFieldOfString = String.class.getDeclaredField("value");  
      
		//改变value属性的访问权限  
		valueFieldOfString.setAccessible(true);  
      
		//获取s对象上的value属性的值  
		char[] value = (char[]) valueFieldOfString.get(s);  
      
		//改变value所引用的数组中的第5个字符  
		value[5] = '_';  
      
		System.out.println("s = " + s);  //Hello_World  
		
	}
}
