package demo;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class LoginController extends Controller{
	@ActionKey("/login")
	public void index() {
		System.out.println(getPara("user.name"));
		System.out.println(getPara("user.pass"));
		renderText("hello world");
	}

}
