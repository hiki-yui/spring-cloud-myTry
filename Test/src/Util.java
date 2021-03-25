import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Util {
    private static SqlSessionFactory factory=null;
    private static String resource="mybatis-config.xml";
    static{
        InputStream in=null;
        try {
            in=Resources.getResourceAsStream(resource);
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();

    public static SqlSession getSession(){
        SqlSession session=threadLocal.get();
        if (session==null){
            session=factory.openSession();
            threadLocal.set(session);
            return session;
        }
        return session;
    }

    public static void close(SqlSession session){
        if (session!=null){
            session.close();
        }
        threadLocal.remove();
    }
}
