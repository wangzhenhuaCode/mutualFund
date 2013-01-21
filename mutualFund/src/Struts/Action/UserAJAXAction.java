package Struts.Action;


import java.util.Iterator;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Hibernate.DAO.IZhenhuawBookmarkDAO;
import Hibernate.DAO.IZhenhuawUserDAO;
import Hibernate.PO.ZhenhuawBookmark;
import Hibernate.PO.ZhenhuawUser;



import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAJAXAction extends ActionSupport{
	private IZhenhuawUserDAO userDAO;//edward
	private String email;
	private String password;
	private String errorInfo="";
	private JSONArray userList;
	private Integer page;
	private JSONObject user;
	private Integer lastPage;
	private Integer bookmarkID;
	private IZhenhuawBookmarkDAO bookmarkDAO;
	public String login(){
		userList=null;
		errorInfo="";
		if(email.length()>0&&password.length()>0){
			if(email.contains("@")&&email.contains(".")){
				ZhenhuawUser u= userDAO.findByProperty("email", email).get(0);
				if(u!=null){
					if(u.getPassword().equals(password)){
						ActionContext ctx=ActionContext.getContext();
						Map<String,Object> session=ctx.getSession();
						session.put("user", u);
						errorInfo="";
						user=new JSONObject();
						user.put("firstName", u.getFirstName());
						user.put("lastName", u.getLastName());
						
					}else{
						errorInfo="Password incorrect!";
					}
					
				}else{
					errorInfo="Email address not existed!";
				}
			}else{
				errorInfo="Email address incorrect!";
			}
		}else{
			errorInfo="Email or password is empty!";
		}
		return Action.SUCCESS;
	}
	public JSONObject getUser() {
		return user;
	}
	public String logout(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		session.clear();
		return Action.SUCCESS;
	}
	public String getUsers(){
		int pagesize=10;
		Integer total=userDAO.count("select count(*) from zhenhuaw_User");
		lastPage=(int) Math.ceil((double)total/(double)pagesize);
		Iterator<ZhenhuawUser> list=userDAO.getListByPage("from ZhenhuawUser", (page-1)*pagesize, pagesize).iterator();
		userList=new JSONArray();
		while(list.hasNext()){
			ZhenhuawUser user=list.next();
			JSONObject u= new JSONObject();
			u.put("firstName", user.getFirstName());
			u.put("lastName", user.getLastName());
			u.put("id", user.getId());
			userList.add(u);
		}
		return Action.SUCCESS;
	}
	public String click(){
		ZhenhuawBookmark b= bookmarkDAO.findByProperty("id", bookmarkID).get(0);
		int click=b.getClickcount();
		click++;
		b.setClickcount(click);
		bookmarkDAO.update(b);
		return Action.SUCCESS;
	}
	
	public Integer getLastPage() {
		return lastPage;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setBookmarkID(Integer bookmarkID) {
		this.bookmarkID = bookmarkID;
	}
	public JSONArray getUserList() {
		return userList;
	}
	public void setUserDAO(IZhenhuawUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setBookmarkDAO(IZhenhuawBookmarkDAO bookmarkDAO) {
		this.bookmarkDAO = bookmarkDAO;
	}
	public Integer getBookmarkID() {
		return bookmarkID;
	}
}
