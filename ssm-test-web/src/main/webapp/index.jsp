<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品列表</title>
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
        <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    </head>
    <body>
        <h2>商品列表</h2>
        <p>You can add User,or Edit_User、Delete_User if you selected an user</p>
        <table id="dg" title="商品操作" class="easyui-datagrid" style="width:700px;height:250px"
               url="<%=request.getContextPath()%>/getItemList"
               toolbar="#toolbar" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr >
                    <th field="id" width="30" >商品id</th>
                    <th field="title" width="50">商品标题</th>
                    <th field="price" width="30">价格</th>
                    <th field="num" width="30">库存数量</th>
                </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增商品</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
        </div>

        <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
             closed="true" buttons="#dlg-buttons">
            <div class="ftitle">商品信息</div>
            <form id="fm" method="post" novalidate>
                <div class="fitem">
                    <label>商品id:</label>
                    <input name="id" class="easyui-textbox" required="true">
                </div>

                <div class="fitem">
                    <label>商品标题:</label>
                    <input name="title" class="easyui-textbox" required="true">
                </div>

                <div class="fitem">
                    <label>价格:</label>
                    <input name="price" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>库存:</label>
                    <input name="num" class="easyui-textbox" required="true">
                </div>
            </form>
        </div>
        <div id="dlg-buttons">
            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
        </div>
        <script type="text/javascript">
            var url_pattern;
            function editUser(){
                var row = $('#dg').datagrid('getSelected');
                if (row){
                    $('#dlg').dialog('open').dialog('setTitle','Edit User');
                    $('#fm').form('load',row);
                    url_pattern = '<%=request.getContextPath()%>/updateItem';
                }
            }
            function newUser(){
                $('#dlg').dialog('open').dialog('setTitle','New User');
                $('#fm').form('clear');
                url_pattern = '<%=request.getContextPath()%>/addItem';
            }
            function saveUser(){
                alert(url_pattern);
                $('#fm').form('submit',{
                    url: url_pattern,
                    onSubmit: function(){
                        return $(this).form('validate');
                    },
                    success: function(result){
                        alert("成功");
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                });
            }
            function destroyUser(){
                var row = $('#dg').datagrid('getSelected');
                if (row){
                    $.messager.confirm('Confirm','确定要删除这个商品么？',function(r){
                        if (r){
                            $.post('<%=request.getContextPath()%>/deleteItem',{id:row.id},function(result){
                                $('#dg').datagrid('reload');
                            },'json');
                        }
                        $('#dg').datagrid('reload');
                    });
                }
            }
        </script>

    </body>
</html>