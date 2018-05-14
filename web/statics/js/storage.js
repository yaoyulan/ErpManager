$(function () {

    //分页
    $("#listDiv").on("click","#pagerBtn",function (e) {
        var pageIndex=$(e.target).attr("pageIndex");
        showList(pageIndex);
    })
    showList(1);
    function showList(pageIndex) {
        $.ajax({
            url:"/ErpManager/pagerShowList.do",
            dataType:"html",
            data:"pageIndex="+pageIndex,
            type:"post",
            success:function (data) {
                $("#listDiv").html(data);
            },
            error:function () {
                alert("加载列表失败");
            }
        })
    }
    
    
    
    
    
    
    
    var commodityNameFalg=false;
    var supplierFalg=false;
    var specificationsFalg=false;
    var specificationUnitFalg=false;
    var numberFalg=false;
    var unitFalg=false;
    var priceFalg=false;
    var storagDateFalg=false;
    var remarksFalg=false;
    var addFalg=false;


    //当失去焦点的时候验证商品名称是否存在
    $("#commodityName").blur(function(){
        var commodityName=$(this).val();
        if (commodityName==""||commodityName==null){
            $("#commodityNameError").css("color","red");
            $("#commodityNameError").text("不能为空");
            commodityNameFalg=false;
        }else{
            isExistCommodityName(commodityName);
        }

    });
    function validity(){
        var commodityName=$("#commodityName").val();
        if(commodityName==""||commodityName==null){
            $("#commodityNameError").css("color","red");
            $("#commodityNameError").text("不能为空");
            commodityNameFalg=false;
        }else{
            isExistCommodityName(commodityName);
        }
        var supplier=$("#supplier").val();
        if(supplier==""||supplier==null){
            $("#supplierError").css("color","red");
            $("#supplierError").text("不能为空");
            supplierFalg=false;
        }else{
            $("#supplierError").css("color","green");
            $("#supplierError").text("✔");
            supplierFalg=true;
        }
        var specifications=$("#specifications").val();
        if(specifications==""||specifications==null){
            $("#specificationsError").css("color","red");
            $("#specificationsError").text("不能为空");
            specificationsFalg=false;
        }else{
            $("#specificationsError").css("color","green");
            $("#specificationsError").text("✔");
            specificationsFalg=true;
        }
        var specificationUnit=$("#specificationUnit").val();
        if(specificationUnit==""||specificationUnit==null){
            $("#specificationUnitError").css("color","red");
            $("#specificationUnitError").text("不能为空");
            specificationUnitFalg=false;
        }else{
            $("#specificationUnitError").css("color","green");
            $("#specificationUnitError").text("✔");
            specificationUnitFalg=true;
        }
        var number=$("#number").val();
        if(number==""||number==null){
            $("#numberError").css("color","red");
            $("#numberError").text("不能为空");
            numberFalg=false;
        }else{
            $("#numberError").css("color","green");
            $("#numberError").text("✔");
            numberFalg=true;
        }
        var unit=$("#unit").val();
        if(unit==""||unit==null){
            $("#unitError").css("color","red");
            $("#unitError").text("不能为空");
            unitFalg=false;
        }else{
            $("#unitError").css("color","green");
            $("#unitError").text("✔");
            unitFalg=true;
    }
        var price=$("#price").val();
        if(price==""||price==null){
            $("#priceError").css("color","red");
            $("#priceError").text("不能为空");
            priceFalg=false;
        }else{
            $("#priceError").css("color","green");
            $("#priceError").text("✔");
            priceFalg=true;
        }
        var storagDate=$("#storagDate").val();
        if(storagDate==""||storagDate==null){
            $("#storagDateError").css("color","red");
            $("#storagDateError").text("不能为空");
            storagDateFalg=false;
        }else{
            $("#storagDateError").css("color","green");
            $("#storagDateError").text("✔");
            storagDateFalg=true;
        }
        var remarks=$("#remarks").val();
        if(remarks==""||remarks==null){
            $("#remarksFalgError").css("color","red");
            $("#remarksFalgError").text("不能为空");
            remarksFalg=false;
        }else{
            $("#remarksFalgError").css("color","green");
            $("#remarksFalgError").text("✔");
            remarksFalg=true;
        }

        if(commodityNameFalg&&supplierFalg&&specificationsFalg&&specificationUnitFalg
        &&numberFalg&&unitFalg&&priceFalg&&storagDateFalg&&remarksFalg){
            addFalg=true;
        }else{
            addFalg=false;
        }

    }
    //把错误信息中内容清空
    function reserError(){
        $("#commodityNameError").text("");
        $("#supplierError").text("");
        $("#specificationsError").text("");
        $("#specificationUnitError").text("");
        $("#numberError").text("");
        $("#unitError").text("");
        $("#priceError").text("");
        $("#storagDateError").text("");
        $("#remarksFalgError").text("");
    }

    //点击添加按钮的操作
    $("#addBtn").click(function(){
        validity();
        if(addFalg){
            var param=$("#addForm").serialize();
            var warehouseNo=$("#warehouseNo").val();
            param+="&&warehouseNo="+warehouseNo;
            addStorage(param);
        }

    })
    //刷新编号
    function flahNo() {
        $.ajax({
            url:"/ErpManager/flahNo.do",
            type:"post",
            dataType:"json",
            success:function (data) {
                $("#warehouseNo").val(data);
            },
            error:function(){
                alert("刷新编号错误");
            }
        })
    }



    /*实行添加*/
    function addStorage(param) {
        $.ajax({
            url:"/ErpManager/addStorage.do",
            type:"post",
            dataType:"JSON",
            data:param,
            success:function(data){
                if(data==1||data=="1"){
                    $("#addInfo").text("保存成功！");
                    showList(1);//刷新一下左边的列表
                    $("#addForm")[0].reset();
                    reserError();
                    flahNo();//刷新一下左边的编号
                }else{
                    $("#addInfo").text("保存失败");
                }

            },
            error:function () {
                alert("通信错误");
            }
        })
    }
    //验证商品名称是否存在
    function isExistCommodityName(name) {
        $.ajax({
            url:"/ErpManager/isExistCommodityName.do",
            type:"post",
            dataType:"JSON",
            data:{"name":name},
            success:function(data){
                if(data==0||data=="0"){

                    $("#commodityNameError").css("color","green");
                    $("#commodityNameError").text("✔");
                    commodityNameFalg=true;
                }else{
                    $("#commodityNameError").css("color","red");
                    $("#commodityNameError").text("已经存在该商品");
                    commodityNameFalg=false;
                }
            },
            error:function () {
                alert("验证商品名称存在错误");
            }
        })
    }

    //当点击TR时，触发函数，使用事件委托获取当前点击的元素信息,需要得到ID才能知道查那一个
    $("#listDiv").on("click","#tbody",function(e){
        var warehouseNo=$(e.target).parent().attr("warehouseNo");
        //改变颜色
        $(e.target).parent().css("background","red");
        $(e.target).parent().siblings().css("background","white");
        /*alert(warehouseNo);*/
        $.ajax({
            url:"/ErpManager/showInfo.do",
            data:"id="+warehouseNo,
            type:"post",
            dataType:"json",
            success:function(data){
                var warehouseNo=$("#warehouseNo").val(data[0].warehouseNo);
                var commodityName=$("#commodityName").val(data[0].commodityName);
                var supplier=$("#supplier").val(data[0].supplier);
                var specifications=$("#specifications").val(data[0].specifications);
                var specificationUnit=$("#specificationUnit").val(data[0].specificationUnit);
                var number=$("#number").val(data[0].number);
                 var unit=$("#unit").val(data[0].unit);
                var price=$("#price").val(data[0].price);
                 var storagDate=$("#storagDate").val(data[0].storagDate);
                 var remarks=$("#remarks").val(data[0].remarks);
            },
            error:function () {
                alert("通信错误");
            }
        })
    })

});