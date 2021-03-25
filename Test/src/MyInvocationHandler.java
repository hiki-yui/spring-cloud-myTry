import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    Object obj=null;
    public MyInvocationHandler(){}
    public MyInvocationHandler(Object o){
        this.obj=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object result=null;
        try{
            session=Util.getSession();
            result=method.invoke(obj,args);
            session.commit();
            return result;
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally{
            Util.close(session);//关闭SqlSession并切短连接
        }
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
        //返还代理对象
    }
}
