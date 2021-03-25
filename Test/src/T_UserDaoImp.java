/*
import org.apache.ibatis.session.SqlSession;

public class T_UserDaoImp implements T_UsersDao {
    public void insert(Users users){
        SqlSession session=Util.getSession();
        session.insert("insert",users);
    }
}
*/
//使用代理自动创建接口的实现类提高效率
//注意mapper中namespace的值必须和接口名相同,增删改查标签的id必须和接口的方法名一样