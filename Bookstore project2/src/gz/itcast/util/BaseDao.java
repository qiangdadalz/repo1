package gz.itcast.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 具体的业务dao的基础类
 *    所有的业务dao类继承次类
 * @author APPle
 *
 */
public class BaseDao<T> {
    //具体的dao上面的泛型类型
    private Class targetClass;
    //表名
    private  String tableName;

    public BaseDao(){
        /**
         * 需要解决的问题：
         * 约定: 具体泛型类型的类名  和 表名 保持一致！！！！
         *  1） 得到具体的业务dao运行过程中的泛型具体类型（Student/Teacher）,可以封装ResultSet
         * 	2) 得到泛型具有类型名称 ，就是表名
         */
        //this:代表当前运行的dao对象
        // 1）this.getClass():代表当前运行dao对象的Class对象
        Class clazz = this.getClass();
        // 2）clazz.getGenericSuperclass():得到当前dao对象的父类（参数化类型）
        Type type = clazz.getGenericSuperclass();
        // 3）把父类类型强转成子类（参数化类型：ParameterizedYype）
        ParameterizedType param = (ParameterizedType)type;
        // 4）param.getActualTypeArguments():得到参数化类型 上面的泛型类型列表
        Type[] types = param.getActualTypeArguments();
        // 5）取出泛型类型列表中的第一个泛型类型
        Type target = types[0];
        // 6）强制成Class类型
        targetClass = (Class)target;
        // 7）取出表名并改为小写
        tableName = targetClass.getSimpleName().toLowerCase();
    }

    public List<T> findAll(){
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (List<T>)qr.query("select * from "+tableName+"", new BeanListHandler(targetClass));

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public T findById(int id){
        try{
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (T)qr.query("select * from "+tableName+" where id=?", new BeanHandler(targetClass),new Object[]{id});
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
