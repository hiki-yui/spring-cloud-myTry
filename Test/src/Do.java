import java.util.List;

public class Do {
    public static void main(String[] args) {
        /*T_UsersDao usersDao=new T_UserDaoImp();*///先前方式
        /*T_UsersDao handler=(T_UsersDao)(new MyInvocationHandler(usersDao).getProxy());*/

        T_UsersDao dao=Util.getSession().getMapper(T_UsersDao.class);

        T_UsersDao handler=(T_UsersDao)new MyInvocationHandler2(dao).getProxy();//后者

        /*Users users=new Users(1l,"helloInvocation","123@1.com",null,null);*/

        //使用代理对象让dao调用方法,并提交事务
        List<Users> list=(List<Users>)handler.saveUser();//查询操作,原本是插入操作,只是魔改测试了一番

        for (Users user:list) {
            System.out.println(user);
        }

    }
}
