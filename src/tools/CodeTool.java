package tools;

public class CodeTool {
    private static Integer num=1;
    public static String getCode(String warehouseNo){
        StringBuffer code=new StringBuffer("TY");
        int num=0;
        if (warehouseNo!=null && !"".equals(warehouseNo)){
            num=Integer.parseInt(warehouseNo.substring(2,10));//将后面的数字提取出来
        }

        num++;//编号加1
        //重新拼接编号

        int addZero=0;
        if((""+num).length()<8){
            addZero=8-(""+num).length();/*添加几个0*/
        }
        for (int i=0;i<addZero;i++){
            code.append(0);//循环加0
        }
        code.append(num);//在0之后加上数字

        return code.toString();//变为字符串
    }
}
