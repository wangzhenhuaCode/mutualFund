package Struts.Action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import Hibernate.DAO.IZhenhuawBookmarkDAO;
import Hibernate.DAO.IZhenhuawUserDAO;
import Hibernate.PO.ZhenhuawBookmark;
import Hibernate.PO.ZhenhuawUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;

//Yuanxin Change 21

public class BookmarkAction extends ActionSupport {
	private List<ZhenhuawBookmark> list;
	private ZhenhuawBookmark bookmark;
	private Integer ownerID;
	private IZhenhuawBookmarkDAO bookmarkDAO;
	private IZhenhuawUserDAO userDAO;
	private Integer bookmarkID;
	//private String url;
	//private String comment;
	private String errorInfo;
	public String viewPeopleBookmark(){
		ZhenhuawUser u=userDAO.findByProperty("id", ownerID).get(0);
		list=bookmarkDAO.findByQuery("from ZhenhuawBookmark where email='"+u.getEmail()+"'");
		return "viewBookmark";
	}
	public String manageBookmark(){
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		ZhenhuawUser u=(ZhenhuawUser)session.get("user");
		list=bookmarkDAO.findByQuery("from ZhenhuawBookmark where email='"+u.getEmail()+"'");
		return "manageBookmark";
	}
	public String addBookmark(){
		if(bookmark.getUrl().equals("")){
			errorInfo="URL empty!";
			return "addBookmark";
		}
		if(bookmark.getComment().equals("")){
			errorInfo="Comment empty!";
			return "addBookmark";
		}
		//ZhenhuawBookmark b=new ZhenhuawBookmark();
		bookmark.setClickcount(0);
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		ZhenhuawUser u=(ZhenhuawUser)session.get("user");
		bookmark.setZhenhuawUser(u);
		bookmarkDAO.save(bookmark);
		//bookmarkDAO.updateBySQL("insert into zhenhuaw_bookmark values(null,'"+u.getEmail()+"','"+bookmark.getUrl()+"','"+bookmark.getComment()+"',0)");
		
		return "backmanage";
	} 
	public String deleteBookmark(){
		bookmarkDAO.delete(bookmarkDAO.findByProperty("id", bookmarkID).get(0));
		return "backmanage";
	}
	public String updateBookmark(){
		if(bookmark.getUrl().equals("")){
			errorInfo="URL empty!";
			return "updateBookmark";
		}
		if(bookmark.getComment().equals("")){
			errorInfo="Comment empty!";
			return "updateBookmark";
		}
		ActionContext ctx=ActionContext.getContext();
		Map<String,Object> session=ctx.getSession();
		ZhenhuawUser u=(ZhenhuawUser)session.get("user");
		bookmark.setZhenhuawUser(u);
		bookmarkDAO.update(bookmark);
		return "backmanage";
	}
	public String gotoAddBookmark(){
		return "addBookmark";
	}
	public String gotoUpdateBookmark(){
		bookmark=bookmarkDAO.findByProperty("id", bookmarkID).get(0);
		return "updateBookmark";
	}
	public ZhenhuawBookmark getBookmark() {
		return bookmark;
	}
	public void setBookmark(ZhenhuawBookmark bookmark) {
		this.bookmark = bookmark;
	}
	public List<ZhenhuawBookmark> getList() {
		return list;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setOwnerID(Integer ownerID) {
		this.ownerID = ownerID;
	}
	public void setBookmarkDAO(IZhenhuawBookmarkDAO bookmarkDAO) {
		this.bookmarkDAO = bookmarkDAO;
	}
	public void setUserDAO(IZhenhuawUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void setBookmarkID(Integer bookmarkID) {
		this.bookmarkID = bookmarkID;
	}
	
	
}
