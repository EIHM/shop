package test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.tm.daoimpl.BookDaoimpl;
import com.tm.daoimpl.UserDaoimpl;
import com.tm.domain.Book;
import com.tm.domain.User;

import com.tm.serviceimpl.BusinessServiceImpl;
import com.tm.userexception.ExistUserException;

public class Test01 {
	
	public static void main(String[] args) {
		 /*BusinessServiceImpl lk=	new BusinessServiceImpl();
		 User user=new User();
		 user.setName("haha");
		 user.setPassword("568741");
		 try {
			lk.register(user);
		} catch (ExistUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		/*BusinessServiceImpl bs=new BusinessServiceImpl();
		User user=bs.login("nima","88888");
		System.out.println(user.getName());*/
		BookDaoimpl bl=new BookDaoimpl();
		LinkedHashMap<Integer,Book> lk=bl.getAllBook();
		Set<Entry<Integer,Book>> en=lk.entrySet();
		for(Entry e:en){
			Book book=(Book) e.getValue();
			System.out.println(book.getBookname()+book.getDescription()+book.getId()+"  "+e.getKey());
		}
		
		String str="1";
		Integer i=Integer.parseInt(str);
		System.out.println(i);

}
}