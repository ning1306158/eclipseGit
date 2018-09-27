package config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;

import Controller.HeeloController;
import Controller.LoginController;
import Model.User;

public class DemoConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JFINAL_TEMPLATE);
		
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/hello", HeeloController.class);
		me.add("/login", LoginController.class);
	}

	@Override
	public void configEngine(Engine me) {
		me.setDevMode(true);
//		me.addSharedFunction("html/login.html");
		
	}

	@Override
	public void configPlugin(Plugins me) {
		 DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost:3306/blog?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123");
		    me.add(dp);
		    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		    arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
		    arp.addSqlTemplate("all.sql");
		    me.add(arp);
		    arp.addMapping("User", User.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

}
