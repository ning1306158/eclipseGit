package Controller;

import com.jfinal.core.Controller;

public class HeeloController extends Controller{
	public void index() {
		render("/html/login.html");
	}
}
