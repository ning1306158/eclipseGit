import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class 从Controller中获得url {
	public static void main(String[] args) throws Exception {
		FileInputStream Controller=new FileInputStream("C:\\Users\\Administrator\\Desktop\\Controller.txt");
		Scanner sc=new Scanner(Controller);
		List<String> url=new ArrayList<String>();
		String prefix="";
		String suffix="";
		String line="";
		while(sc.hasNext())
		{
			line=sc.nextLine();
			if(line.startsWith("@Controller"))
			{
				System.out.println(line);
				prefix=line.substring(line.indexOf("\"")+1,line.lastIndexOf("\""));
				break;
			}
		}
		while(sc.hasNext())
		{
			line=sc.nextLine().trim();
			if(line.startsWith("public void"))
			{
				suffix=line.substring(line.indexOf("void ")+5,line.lastIndexOf("("));
				System.out.println(suffix);
				url.add(prefix+"/"+suffix);
			}
			
		}
		sc.close();
		for (String string : url) {
			System.out.println(string);
		}
	}

}
