$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});


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
                title: '账目名称'
            }, {
                field: 'billDesc',
                title: '账目描述'
            }, {
                field: 'createTime',
                title: '创建时间'
            }, {
                field: 'createUser',
                title: '创建人'
            }, {
                field: 'billDetailId',
                title: '账目详情'
            }],
          //注册加载子表的事件。注意下这里的三个参数！
            onExpandRow: function (index, row, $detail) {
            	oTableInit.InitSubTable(index, row, $detail);
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
    
  //初始化子表格(无线循环)
    oTableInit.InitSubTable = function (index, row, $detail) {
        var parentid = row.billDetailId;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: '/queryBillDetailList',
            method: 'get',
            queryParams: { strParentID: parentid },
            ajaxOptions: { strParentID: parentid },
            clickToSelect: true,
            detailView: true,//父子表
            uniqueId: "billDetailId",
            pageSize: 10,
            pageList: [10, 25],
            columns: [{
                checkbox: true
            }, {
                field: 'preMonthPrincipal',
                title: '上月本息和'
            }, {
                field: 'currentMonthPrincipal',
                title: '当月本息和'
            }, {
                field: 'currentMonthInput',
                title: '当月投入'
            }, {
                field: 'currentmonthincome',
                title: '当月收益'
            }, ],
            //无线循环取子表，直到子表里面没有记录
            onExpandRow: function (index, row, $Subdetail) {
            	oTableInit.InitSubTable(index, row, $Subdetail);
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
