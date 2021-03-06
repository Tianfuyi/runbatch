package com.cmi.Modle;

import com.cmi.log.LogWriter;
import com.cmi.tools.DBUtil;
import com.cmi.tools.DataParse;
import org.testng.Reporter;

import java.io.IOException;

/**
 * 数据准备预处理模块功能封装
 */
public class PreProcessAction {

    public Boolean preProcess(String dbAddress) throws IOException {

        LogWriter.info(PreProcessAction.class,"**********执行预处理功能**********");
        try {
            DBUtil.delete((DataParse.GetProperties("framework.properties", "SQL_MAG_100_DELETE")), dbAddress);

            DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_MAG_100_UPDATE")), dbAddress);

            DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_LOG_all_UPDATE")), dbAddress);

            LogWriter.info(PreProcessAction.class,"**********结束预处理功能**********");
            return true;
        }catch (Exception e){
            Reporter.log("数据预处理失败");
            e.printStackTrace();
            return false;
        }

    }


    public  Boolean changePwd(String date,String dbAddress) throws IOException{
        try {


            DBUtil.update("update cmis.s_usr set PASS_MODI_DT = (select CUR_PRCS_DT from cmis.S_CTRL) where usr_cde = 'admin'", dbAddress);
            return true;
        }catch (Exception e){
            Reporter.log("密码更新失败");
            e.printStackTrace();
            return false;
        }
    }
}
