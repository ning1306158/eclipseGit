package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import Model.User;

public class LoginController extends Controller{
	@ActionKey("/login")
	public void index() {
		User u=getModel(User.class);
		String sql=Db.getSql("findGirl");
		List<Record> li=Db.find(sql,u.getStr("name"),u.getStr("pass"));
		if(li.size()>0)
		{
			renderText("hello world");
			
		}
		else
		{
			setAttr("mess", "您的账号或密码有误！！！");
			render("/html/login.html");
		}
	}

}
