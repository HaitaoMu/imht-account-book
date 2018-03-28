$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
 
    //禁用空白处点击关闭
    $('#addModel').modal({
  	  backdrop: 'static',
  	  keyboard: true,//禁止键盘
  	  show:false
     });
    
    centerModals();
    
    //页面大小变化是仍然保证模态框水平垂直居中
    $(window).on('resize', centerModals);
    
    $('form').submit(function (event) {
        event.preventDefault(); 
        var form = $(this);
        if (!form.hasClass('fupload')) {
          //普通表单
          $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize()
          }).success(function () {
             $('#closeBtnForAddBill').click();
             refreshList();
             oTable.ToolTip("success");
          }).fail(function (jqXHR, textStatus, errorThrown) {
        	  oTable.ToolTip("error");
          });
        }
    });
    
    //页面删除操作
    $("#btn_delete").on("click",function(){
    	var deleteIdArray = [];
        //收集页面中被选中的数据项
        $("input[name='btSelectItem']").each(function(){
            if($(this).is(':checked')){
            	var billId = $(this).parent().parent().attr("data-uniqueid");
            	deleteIdArray.push(billId);
            }
        });
        if($.isEmptyObject(deleteIdArray))
        {
        	alert("请选中所要删除的数据项");
        	return;
        }
        $.ajax({
            type: "POST",
            url: "/imht-web-service/deleteBill",
            data: { billIds:deleteIdArray.toString()},
            success: function (data) {
            	refreshList();
            	if(data > 0){
            		oTable.ToolTip("success");
            	}
            	else{
            		oTable.ToolTip("error");
        		}
            },
            error: function () {
            	oTable.ToolTip("error");
            },
            complete: function () {

            }

        });         
    });

});

//模态框居中
function centerModals() {   
　　$('#addModal').each(function(i) {   
　　　　var $clone = $(this).clone().css('display','block').appendTo('body');
　　　　var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);
　　　　top = top > 0 ? top : 0;   
　　　　$clone.remove();   
　　　　$(this).find('.modal-content').css("margin-top", top);   
　　});   
};
	
//刷新表格数据
function refreshList(){
    $.ajax({
        type: "get",
        url: "/imht-web-service/queryBillList",
        data: {},
        success: function (data) {
            $("#accountManage").bootstrapTable('refresh', data);
        },
        error: function () {

        },
        complete: function () {

        }

    }); 	
}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D+h+m+s;
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#accountManage').bootstrapTable({
            url: '/imht-web-service/queryBillList',              //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "billId",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: true,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'billName',
                title: '账目名称',
                editable:true
            }, {
                field: 'billDesc',
                title: '账目描述',
                editable:true
            }, {
                field: 'createTime',
                title: '创建时间',
                formatter: function indexFormatter(value, row, index) {//格式化时间
                    return timestampToTime(value);
                }                
            }, {
                field: 'createUser',
                title: '创建人'
            }],
          //注册加载子表的事件。注意下这里的三个参数！
            onExpandRow: function (index, row, $detail) {
            	oTableInit.InitSubTable(index, row, $detail);
            	setTimeout(function(){
	            	var addBtnHtml = "<button type='button' class='btn btn-default billDetailAddBtn' data-toggle='modal' data-target='#addModal'>"
	                +"<span class='glyphicon glyphicon-plus' aria-hidden='true'></span>新增</button>";
	            	$("table[class='table table-hover']").find("thead").find("tr").each(function(){
	            		if(!$(this).children().hasClass("billDetailAddBtn"))
	            		{
		            		$(this).append(addBtnHtml);	
	            		}
	            	});
            	},10);
            },
            //编辑保存事件
            onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    type: "post",
                    url: "/imht-web-service/updateBill",
                    data: { billId:row.billId,
                    	billName:row.billName,
                    	billDesc:row.billDesc},
                    success: function (data, status) {
                    	oTableInit.ToolTip("success");
                    },
                    error: function () {
                    	oTableInit.ToolTip("error");
                    },
                    complete: function () {

                    }

                });
            }
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            status: $("#txt_search_statu").val(),
            search: params.search
        };
        return temp;
    };
    
    //操作提示框
    oTableInit.ToolTip = function(type){
    	if("success" == type){	
	    	$('#mySuccessAlert').show();
	    	setTimeout(function(){
	    		$('#mySuccessAlert').hide();
	    	},1000);
    	}else{
	    	$('#myErrorAlert').show();
	    	setTimeout(function(){
	    		$('#myErrorAlert').hide();
	    	},1000);
		}
    },
    
   //初始化子表格(无线循环)
    oTableInit.InitSubTable = function (index, row, $detail) {
        var parentId = row.billId;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: '/imht-web-service/queryBillDetailList',
            method: 'get',
            queryParams: { billDetailId: parentId },
            ajaxOptions: { billDetailId: parentId },
            clickToSelect: true,
            cache: false, 
            detailView: false,//父子表
            uniqueId: "billDetailId",
            pageSize: 10,
            pageList: [10, 25],
            columns: [
            	{
                field: 'operator',
                title: '操作'
            },            	
            	{
                field: 'currentYear',
                title: '当前年份'
            },
            	{
                field: 'currentMonth',
                title: '当前月份'
            },
            	{
                field: 'preMonthPrincipal',
                title: '上月本息和',
                editable:true
            }, {
                field: 'currentMonthPrincipal',
                title: '当月本息和',
                editable:true
            }, {
                field: 'currentMonthInput',
                title: '当月投入',
                editable:true
            }, {
                field: 'currentMonthIncome',
                title: '当月收益',
                editable:true
            } ],
            //无线循环取子表，直到子表里面没有记录
            onExpandRow: function (index, row, $Subdetail) {
            	oTableInit.InitSubTable(index, row, $Subdetail);
            },
            //编辑保存事件
            onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    type: "post",
                    url: "/imht-web-service/saveDetailBill",
                    data: {billId:row.billId,
                    	currentYear:row.currentYear, 
                    	currentMonth:row.currentMonth,
                    	billDetailId:row.billDetailId,
                    	preMonthPrincipal:row.preMonthPrincipal,
                    	currentMonthPrincipal:row.currentMonthPrincipal,
                    	currentMonthInput:row.currentMonthInput,
                    	currentMonthIncome:row.currentMonthIncome},
                    success: function (data, status) {
                    	oTableInit.ToolTip("success");
                    },
                    error: function () {
                    	oTableInit.ToolTip("error");
                    },
                    complete: function () {

                    }

                });
            }
        });
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};
