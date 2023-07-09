let registerData;
const getRegisterList = () =>{
    $.post("./getRegisterList", {"stage":"MAIN_GATE"}, function(data) {
            let parsedData = JSON.parse(data);            
            if(data != "failure"){        
                registerData = parsedData;        
                addExitVehicles();                
            }   
        });
}

const addExitVehicles = () =>{
    let htmlStr = '';
    registerData.forEach((val, index)=>{
        let entry = val;
        htmlStr += '<div class="vcenter" onClick="showRegisterDetails(\''+val['id']+'\')">'+val['truckNo']+'</div>';
    });    
    $("#container").html(htmlStr);
}

const showRegisterDetails = (id) =>{        
    $("#container").attr("style", "display:none")
    $("#exitFormDtls").attr("style", "display:block")
    setFormValues(getRegisterDataById(id));
}

const setFormValues = (data) =>{
    $('input[name="registerId"]').val(data['id']);
    $('input[name="truckNo"]').val(data['truckNo']);
    $('input[name="wayBillNo"]').val(data['wayBillNo']);
    $('input[name="millerName"]').val(data['millName']);
    $('input[name="millerPlace"]').val(data['millPlace']);
    $('input[name="veriety"]').val(data['veriety']);
    $('input[name="bags"]').val(data['bags']);
    $('input[name="inTime"]').val(data['inTime']);
}

const getRegisterDataById = (id) =>{
    let result = {};
    registerData.forEach((val, index)=>{
        if(val['id'] == id)
            result = val;
    });     
    return result;
}

const saveExitForm = () =>{
    $("#exitFormDtlsForm").submit();           
}

