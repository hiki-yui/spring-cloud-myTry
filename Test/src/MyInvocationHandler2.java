import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler2 implements InvocationHandler {
    Object object=null;

    public MyInvocationHandler2() {
    }

    public MyInvocationHandler2(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args){
        SqlSession session=Util.getSession();
        Object result=null;
        try{
            result=method.invoke(object,args);
            session.commit();
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Util.close(session);
        }
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
}
