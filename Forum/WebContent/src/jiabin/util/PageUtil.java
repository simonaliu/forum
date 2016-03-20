package jiabin.util;

/**
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * @param targetUrl
	 * @param totalNum
	 * @param currentPage 
	 * @param pageSize
	 * @return
	 */
	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize,String param){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "";
		}else{
			StringBuffer pageCode=new StringBuffer();
			if (currentPage==1) {
				pageCode.append("<li class=disabled><a></a></li>");
			} else {
				pageCode.append("<li><a href='"+targetUrl+"?page=1&"+param+"'></a></li>");
			}
			if(currentPage==1){
				pageCode.append("<li class=disabled><a></a></li>");
			}else {
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"&"+param+"'></a></li>");			
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					pageCode.append("<li class=active><a>"+i+"</a></li>");		
				}else{
					pageCode.append("<li><a href='"+targetUrl+"?page="+i+"&"+param+"'>"+i+"</a></li>");	
				}
			}
			if(currentPage==totalPage){
				pageCode.append("<li class=disabled><a></a></li>");	
			}else {
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"&"+param+"'></a></li>");	
			}
			if (currentPage==totalPage) {
				pageCode.append("<li class=disabled><a></a></li>");
			} else {
				pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"&"+param+"'></a></li>");
			}
			return pageCode.toString();
		}
	}
	
	public static String genPaginationNoParam(String targetUrl,long totalNum,int currentPage,int pageSize){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+targetUrl+"?page=1'></a></li>");
			if(currentPage>1){
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"'></a></li>");			
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					pageCode.append("<li>"+i+"</li>");		
				}else{
					pageCode.append("<li><a href='"+targetUrl+"?page="+i+"'>"+i+"</a></li>");	
				}
			}
			if(currentPage<totalPage){
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"'></a></li>");		
			}
			pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"'></a></li>");
			return pageCode.toString();
		}
	}
}
