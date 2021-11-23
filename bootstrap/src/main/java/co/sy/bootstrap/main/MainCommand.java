package co.sy.bootstrap.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sy.bootstrap.comm.Command;

public class MainCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		return "main/main";
	}

}
