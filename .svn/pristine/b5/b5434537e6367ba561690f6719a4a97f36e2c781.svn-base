package com.cmi.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonUtil {


    public Map jsonToMaps(String str) {
        Map json = (Map) JSONObject.parse(str);
    //    System.out.println("json size "+json.size());
        for (Object map: json.entrySet()){
         System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
        }
    //    System.out.println(json);
        return json;
    }


    public static void main(String[] args) {
        JsonUtil json= new JsonUtil();

        String str="{\"runState\":\"未运行\",\n" +
                "\"rows\":[\n" +
                "{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"ACCSTEP\",\"start_run_time\":\"18:01:11\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:01:17\",\"seq_no\":\"100\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"Y\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日终处理生成核算日终任务步骤\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"ACCAFTER\",\"start_run_time\":\"18:01:17\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:04:01\",\"seq_no\":\"110\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"Y\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日终处理触发核算日终任务处理\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"INTENTMANAGE\",\"start_run_time\":\"18:04:01\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:04:01\",\"seq_no\":\"150\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"Y\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日终意向登记绩效统计\"},\n" +
                "{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"LNAT\",\"start_run_time\":\"18:04:01\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:04:01\",\"seq_no\":\"200\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"C\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"消费信贷管理系统换日\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"ACCBEFORE\",\"start_run_time\":\"18:04:01\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:04:01\",\"seq_no\":\"220\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日初处理触发核算日初任务处理\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"CHARGESCALCULATION\",\"start_run_time\":\"18:04:01\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:04:01\",\"seq_no\":\"230\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日初处理触发服务费计算\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"COOPRSTSCHG\",\"start_run_time\":\"18:04:01\",\"job_typ\":\"JAVA\",\"mac_time\":\"2019-03-25 18:04:01\",\"seq_no\":\"270\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日初项目批量失效\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"LCAPPLCONT\",\"start_run_time\":\"18:04:01\",\"job_typ\":\"\",\"mac_time\":\"2019-03-25 18:04:03\",\"seq_no\":\"280\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日初贷款合同过期处理\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"WHITELIST\",\"start_run_time\":\"18:04:03\",\"job_typ\":\"\",\"mac_time\":\"2019-03-25 18:04:03\",\"seq_no\":\"300\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日初白名单处理\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"SYNCHRO\",\"start_run_time\":\"18:04:03\",\"job_typ\":\"\",\"mac_time\":\"2019-03-25 18:04:11\",\"seq_no\":\"350\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日初数据同步\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"LOANSTATISTICS\",\"start_run_time\":\"18:04:11\",\"job_typ\":\"\",\"mac_time\":\"2019-03-25 18:04:20\",\"seq_no\":\"360\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"C\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"换日放款情况统计\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"PREREGISTER\",\"start_run_time\":\"18:04:20\",\"job_typ\":\"\",\"mac_time\":\"2019-03-25 18:04:20\",\"seq_no\":\"362\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"Y\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"客户预登记日终任务\"},{\"ignore_flag\":\"Y\",\"err_msg\":\"\",\"job_exe\":\"UTILIZARAT\",\"start_run_time\":\"18:04:20\",\"job_typ\":\"\",\"mac_time\":\"2019-03-25 18:04:21\",\"seq_no\":\"370\",\"instu_cde\":\"900000000\",\"job_accredit\":\"LOAN\",\"job_freq\":\"D\",\"job_sts\":\"FIN\",\"eod_flag\":\"N\",\"prcs_dt\":\"2021-01-16\",\"job_nam\":\"日终平均额度计算\"}]}\n";
        Map m= json.jsonToMaps(str);
        String runState=m.get("runState").toString();
        System.out.println(runState);
    }


}
