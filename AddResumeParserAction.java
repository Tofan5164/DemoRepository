package com.parser.action;

import java.util.Set;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.parser.base.action.BaseAction;
import com.parser.common.util.LogUtil;
import com.parser.manager.ParserManager;
import com.parser.vo.ParserVO;

public class AddResumeParserAction extends BaseAction{
	@Override
	public ActionForward parseExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LogUtil.debug("=========== inside AddResumeParserAction:execute");
		    ParserVO parserData = (ParserVO)form;
		    HttpSession session = request.getSession();
		    Set<String> userList = (Set<String>) session.getAttribute("SET1");		   	        
	        ParserManager.startParser(parserData,userList);
	        return mapping.findForward("success");
	     
	}

}
