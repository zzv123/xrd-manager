//加载页面时，加载日志列表和设备列表
getAllLog();
getAllEquipment();
//获得所有的日志
function getAllLog() {
    $.ajax({
        url:"/getAllLog",
        type:"get",
        dataType:"json",
        success: function (data){
            console.log(data);
            var html="";
            for(var i=0;i<data.data.length;i++){
                data.data[i];
                html+='<div class="row">'
                html+='        <div class="col-xs-2 ">'
                html+=(i+1)
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+='<span>'+data.data[i].admin.username+'</span>'
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].admin.name
                html+='</div>'
                html+='<div class="col-xs-3">'
                html+=data.data[i].ip
                html+='</div>'
                html+='<div class="col-xs-3">'
                html+=data.data[i].loginTime.substring(0,19).replace("T","/")
                html+='</div>'
                html+='</div>'

            }
            $("#allLog").append(html);
        }
    })

}
//添加设备
function add_Equipment() {
    $.ajax({
        url:"/addEquipment",
        type:"get",
        data:{
            name:$("#e_add_name").val(),
            person:$("#e_add_person").val(),
            brand:$("#e_add_brand").val(),
            number:$("#e_add_number").val()
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            alert(data.msg);
            $("#equipment_list").empty();
            //再调用函数，重新异步加载并显示新数据
            getAllEquipment();


        }
    })

}
//获得所有的设备
function getAllEquipment() {
    $.ajax({
        url:"/getAllEquipment",
        type:"get",
        dataType:"json",
        success: function (data){
            console.log(data);
            var html="";
            for(var i=0;i<data.data.length;i++){
            html+='<div class="row">'
                html+='<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">'
                html+=(i+1)
                html+='</div>'
                html+='<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">'
                html+=data.data[i].name
                html+='</div>'
                html+='<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">'
                html+='<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update_equipment('+data.data[i].id+')">详情</button>'
                html+='<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource" onclick="delete_equipment('+data.data[i].id+')">删除</button>'
                html+='</div>'
                html+='</div>'

            }

            $("#equipment_list").append(html);



        }
    })

}
//修改设备
function  update_equipment(id){
    console.log(id);
    $.ajax({
        url:"/getEquipmentById",
        type:"get",
        data:{
            id:id
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            $("#e_update_name").val(data.data.name);
            $("#e_update_person").val(data.data.person);
            $("#e_update_brand").val(data.data.brand);
            $("#e_update_number").val(data.data.number);

            //修改保存按钮
            $("#bc_equipment").attr("onclick","bc_equipment("+id+")");


        }
    })
}
//修改设备的保存按钮
function bc_equipment(id) {

    $.ajax({
        url:"/updateEquipmentById",
        type:"get",
        data:{
            id:id,
            name:$("#e_update_name").val(),
            person:$("#e_update_person").val(),
            brand:$("#e_update_brand").val(),
            number:$("#e_update_number").val()
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            alert(data.msg);
            //先通过 id 删除原数据
            $("#equipment_list").empty();
            //再调用函数，重新异步加载并显示新数据
            getAllEquipment();


        }
    })

}

function delete_equipment(id){

    $("#delete_Equipment_button").attr("onclick","delete_equipmentById("+id+")");

}
function delete_equipmentById(id) {

    console.log("要删除的数据为"+id);

    $.ajax({
        url:"/deleteEquipmentById",
        type:"get",
        data:{
            id:id
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            alert(data.msg);
            //先通过 id 删除原数据
            $("#equipment_list").empty();
            //再调用函数，重新异步加载并显示新数据
            getAllEquipment();
        }
    })

}

//获得所有的设备详情列表
equipment_details_list()
function equipment_details_list() {
    $.ajax({
        url:"/getAllEquipment",
        type:"get",
        dataType:"json",
        success: function (data){
            console.log(111);
            console.log(data);
            console.log(222);

            var html="";
            for(var i=0;i<data.data.length;i++){

                html+='<div class="row">'
                html+='<div class="col-xs-1 ">'
                html+=(i+1)
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].name
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+=data.data[i].person
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+=data.data[i].brand
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].number
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+='<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseSchool"onclick="update_details_equipment('+data.data[i].id+')">详情</button>'
                html+='<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSchool"onclick="delete_details_equipment('+data.data[i].id+')">删除</button>'
                html+='</div>'
                html+='</div>'

            }

            $("#equipment_details_list").append(html);



        }
    })

}

//修改设备详情
function  update_details_equipment(id){
    console.log(id);
    $.ajax({
        url:"/getEquipmentById",
        type:"get",
        data:{
            id:id
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            $("#details_update_name").val(data.data.name);
            $("#details_update_person").val(data.data.person);
            $("#details_update_brand").val(data.data.brand);
            $("#details_update_number").val(data.data.number);

            //修改保存按钮
            $("#details_bc").attr("onclick","bc_equipment_details("+id+")");


        }
    })
}

//修改设备的保存按钮
function bc_equipment_details(id) {

    $.ajax({
        url:"/updateEquipmentById",
        type:"get",
        data:{
            id:id,
            name:$("#details_update_name").val(),
            person:$("#details_update_person").val(),
            brand:$("#details_update_brand").val(),
            number:$("#details_update_number").val()
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            alert(data.msg);
            //先通过 id 删除原数据
            $("#equipment_details_list").empty();
            //再调用函数，重新异步加载并显示新数据
            equipment_details_list();


        }
    })

}


function delete_details_equipment(id){

    $("#delete_Equipment_details_button").attr("onclick","delete_details_equipmentById("+id+")");

}
function delete_details_equipmentById(id) {

    console.log("要删除的数据为"+id);

    $.ajax({
        url:"/deleteEquipmentById",
        type:"get",
        data:{
            id:id
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            alert(data.msg);
            //先通过 id 删除原数据
            $("#equipment_details_list").empty();
            //再调用函数，重新异步加载并显示新数据
            equipment_details_list();

        }
    })

}


function add_admin() {
    console.log(1);
    $.ajax({
        url:"/addAdmin",
        type:"post",
        data:{
            jobnumber:$("#add_jobnumber").val(),
            name:$("#add_name").val(),
            department:$("#add_department").val(),
            username:$("#add_username").val(),
            password:$("#add_password").val(),
            power:$("#add_power").val(),
            job:$("#add_job").val()
        },
        dataType:"json",
        success: function (data){
            console.log(data);
            alert(data.msg);
            //先通过 id 删除原数据
           // $("#equipment_details_list").empty();
            //再调用函数，重新异步加载并显示新数据
            //equipment_details_list();

        }
    })


}
allAdmin();
function allAdmin() {

    $.ajax({
        url:"/getAllAdmin",
        type:"get",
        dataType:"json",
        success: function (data){


            var html="";
            for(var i=0;i<data.data.length;i++){
                html+='<div class="row">'
                html+='<div class="col-xs-2 ">'
                html+=(i+1)
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+=data.data[i].name
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].department
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].username
                html+='</div>'
                html+='<div class="col-xs-2">'
                if(data.data[i].power==0){
                    html+="普通用户"
                }else{
                    html+="管理员"
                }
                html+='</div>'
                html+='<div class="col-xs-2">'
                html+=data.data[i].job
                html+='</div>'
                html+='<div class="col-xs-1">'
                html+='<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseSchool"onclick="updateAdmin('+data.data[i].id+')">修改</button>'
                html+='</div>'
                html+='</div>'

            }

            $("#allAdmin").append(html);



        }
    })
    
}
function deleteToken(){
    $.ajax({
        url: "/deleteToken",
        type: "get",
        data: {
            token: $.cookie("token")
        },
        dataType: "json",
        success: function (data) {
                alert(data.msg);
                window.location.href="/";

        }
    })
}