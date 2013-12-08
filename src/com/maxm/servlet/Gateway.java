package com.maxm.servlet;

import java.io.IOException;
import java.security.InvalidParameterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maxm.service.CardService;
import com.maxm.util.JSONUtil;
import com.maxm.util.StringUtil;

@SuppressWarnings("serial")
public class Gateway extends HttpServlet {
	private final static Logger log = Logger.getLogger(Gateway.class);

	public Gateway() {
		super();
		log.info("construct Gateway obj ...");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
			ServletException {
		String data = req.getParameter("data");
		if (StringUtil.isEmpty(data)) {
			log.error("invalid request");
			return;
		}
		JSONArray dataArray = JSON.parseArray(data);
		if (dataArray == null || dataArray.size() == 0) {
			log.error("invalid request");
			return;
		}
		for (Object obj : dataArray) {
			JSONObject json = JSONUtil.toJSON(obj);
			String cmd = json.getString("cmd");
			handleCmd(json, cmd);
			resp.getWriter().write(json.toJSONString());
		}
	}

	private static void handleCmd(JSONObject json, String cmd) {
		switch (cmd) {
		case "createCard":
			CardService.createCard(json);
			break;
		default:
			log.error("unknown cmd,cmd=" + cmd);
			throw new InvalidParameterException("cmd=" + cmd);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,
			ServletException {
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
		log.info("destroy Gateway obj:" + this.getServletName());
	}
}
