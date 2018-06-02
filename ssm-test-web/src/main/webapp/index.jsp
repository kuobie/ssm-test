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
        <table id="dg" title="用户操作" class="easyui-datagrid" style="width:700px;height:250px"
               url="<%=request.getContextPath()%>/userList"
               toolbar="#toolbar" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
            <tr >
                <th field="id" width="30" >用户ID</th>
                <th field="name" width="50">姓名</th>
                <th field="password" width="30">密码</th>
            </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建用户</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
        </div>

        <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
             closed="true" buttons="#dlg-buttons">
            <div class="ftitle">用户信息</div>
            <form id="fm" method="post" novalidate>
                <div class="fitem">
                    <label>用户ID:</label>
                    <input name="id" class="easyui-textbox" required="true" >
                </div>
                <div class="fitem">
                    <label>姓名:</label>
                    <input name="name" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>密码:</label>
                    <input name="password" type="password" class="easyui-textbox" required="true">
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
                    url_pattern = '<%=request.getContextPath()%>/updateUser';
                }
            }
            function newUser(){
                $('#dlg').dialog('open').dialog('setTitle','New User');
                //  $('#fm').form('clear');
                url_pattern = '<%=request.getContextPath()%>/addMyuser';
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
                    $.messager.confirm('Confirm','确定要删除这个用户么？',function(r){
                        if (r){
                            $.post('<%=request.getContextPath()%>/deleteUser',{id:row.id},function(result){
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