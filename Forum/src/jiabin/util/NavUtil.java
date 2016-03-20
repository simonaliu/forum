package jiabin.util;

/**
 * @author Administrator
 *
 */
public class NavUtil {

	/**
	 * @param subName
	 * @return
	 */
	public static String genNavCode(String subName){
		StringBuffer navCode=new StringBuffer();
		navCode.append("");
		navCode.append("<a href='index.jsp'></a>&nbsp;");
		navCode.append("&gt; ");
		navCode.append(subName);
		return navCode.toString();
	}
}
