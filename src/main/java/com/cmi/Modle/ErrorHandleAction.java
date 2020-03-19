package com.cmi.Modle;

import com.cmi.listObject.LogListBean;
import com.cmi.listObject.MagListBean;
import com.cmi.log.LogWriter;
import com.cmi.tools.DBUtil;
import com.cmi.tools.DataParse;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.Reporter;

import java.io.IOException;
import java.util.List;

/**
 * 进程错误处理功能模块封装
 */
public class ErrorHandleAction {

public  String address;
    public ErrorHandleAction(String _address) {
        address=_address;
    }


    /**获取信贷出错进程号
     * @param session
     * @return
     */
    public String getMagErrorProcess(String session){

        String MagsqeNo="";
        List<MagListBean> list =  new ApiAction(address).magList(session);
        for(int i=0;i<list.size();i++){
            if(!list.get(i).getJob_sts().equals("FIN")){    //任务状态非完成状态
                String job_name=   list.get(i).getJob_nam();
                MagsqeNo= list.get(i).getSeq_no();

                LogWriter.info(ApiAction.class,"运行批次出错 出错程序名称："+job_name+ "程序序号："+MagsqeNo);
                Reporter.log("运行批次出错 出错程序名称："+job_name+ "程序序号："+MagsqeNo);
                break;
            }
        }
        return MagsqeNo;
    }


    /** 信贷进程错误处理
     * @param MagsqeNo
     */
    public Boolean fixMagError(String MagsqeNo,String session,String dbAddress) throws IOException {
        LogWriter.info(ErrorHandleAction.class,"信贷批次任务出错 出错程序号："+MagsqeNo);
        Boolean result;
        switch (MagsqeNo){

            case "100":
                try {
                    DBUtil.delete((DataParse.GetProperties("framework.properties", "SQL_MAG_100_DELETE")), dbAddress);
                    DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_MAG_100_UPDATE")), dbAddress);
                    result=true;
                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;


                // 信贷进程110 出错  则检查 核算任务进程
            case "110":
                try {
                    LogWriter.info(ErrorHandleAction.class,"信贷批次程序110 出错 检查核算批次任务！");
                    String LogErrorSqe = getLogErrorProcess(session);
                    result = fixLogError(LogErrorSqe, session, dbAddress);

                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;
            default :
             LogWriter.info(ErrorHandleAction.class,"出错任务处理没有匹配项，请手动检查！");
               result=false;
                break;
        }
        return result;

    }

    /**获取核算出错进程号
     * @param session
     * @return
     */
    public String getLogErrorProcess(String session){

        String sqeNo="";
        List<LogListBean> list = new ApiAction(address).logList(session);
        for(int i=0;i<list.size();i++){
            if(!list.get(i).getJob_sts().equals("FIN")){    //任务状态非完成状态
                String job_name=   list.get(i).getJob_nam();
                sqeNo= list.get(i).getSeq_no();

                LogWriter.info(ApiAction.class,"运行批次出错 出错程序名称："+job_name+ "程序序号："+sqeNo);
                Reporter.log("运行批次出错 出错程序名称："+job_name+ "程序序号："+sqeNo);
                break;
            }
        }
        return sqeNo;
    }

    /**
     * @param LogseqNo
     * @param session
     * @param dbAddress
     * @throws IOException
     */
    public Boolean fixLogError(String LogseqNo,String session,String dbAddress) throws IOException {
        LogWriter.info(ErrorHandleAction.class,"运行核算批次出错 出错程序号："+LogseqNo);
        Boolean result=false;
		int i=0;
        switch (LogseqNo){

            case "229":
                try {
                    DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_LOG_229_UPDATE")), dbAddress);
                    result = true;
                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;


            case "240":
                try{
                    DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_LOG_240_UPDATE")), dbAddress);
                    result=true;
                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;

            case "580":
                try{
                DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_LOG_580_UPDATE")), dbAddress);
                    result=true;
                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;

            case "820":
                try{
                DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_LOG_820_UPDATE")), dbAddress);
                    result=true;
                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;

            case "850":
                try{
                DBUtil.update((DataParse.GetProperties("framework.properties", "SQL_LOG_850_UPDATE")), dbAddress);
                    result=true;
                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;

            case "231":
                try{
                    Thread.sleep(20000);

                }catch (Exception e){
                    e.printStackTrace();
                    result=false;
                }
                break;


            default :
                LogWriter.info(ErrorHandleAction.class,"出错任务处理没有匹配项，请手动检查！");
                result=false;
                break;
        }
         return result;

    }


}
