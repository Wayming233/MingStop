package ming.stop.biz.admin.dao.impl;

import com.ming.utils.JDBCUtil;
import ming.stop.base.BaseDao;
import ming.stop.biz.admin.dao.OrderitemDao;
import ming.stop.entity.Orderitem;
import ming.stop.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

/**
 * Created by Ming on 2017/8/23.
 */
public class OrderitemDaoImpl extends BaseDao<Orderitem> implements OrderitemDao {

    @Override
    //保存订单项
    public boolean submitOrderitem(Orderitem orderitem) throws Exception {
        String sql = "insert into orderitem values(?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection();//事务控制
        int len = queryRunner.update(connection,sql,
                orderitem.getItemid(),orderitem.getCount(), orderitem.getSubtotal(),
                orderitem.getProduct().getPid(), orderitem.getOrders().getOid());
        return len >0? true:false;
    }
    @Override
    //更新订单项
    public boolean updateOrderitem(Orderitem orderitem) throws Exception {
        String sql = "update orderitem set count = ? ,subtotal = ? ,pid = ? where itemid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        int len = queryRunner.update(sql, orderitem.getCount(), orderitem.getSubtotal(), orderitem.getProduct().getPid(),orderitem.getItemid());
        return len >0? true:false;
    }


}
