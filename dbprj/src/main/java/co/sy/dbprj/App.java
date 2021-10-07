package co.sy.dbprj;

import co.sy.dbprj.db.DevServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //DataSource dao = new DataSource();
    	DevServiceImpl dao = new DevServiceImpl();
    	dao.selectList();
    }
}
