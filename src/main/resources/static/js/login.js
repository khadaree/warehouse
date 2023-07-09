const login = ()=> {
    if(isValid()){        
      $("#loginForm").submit();
        // $.post("./login", $("#loginForm").serialize(), function(data) {
        //     alert(data)
        //     if(data == "success")
        //         $("#loginForm").submit();
        // });
    }
} 

const isValid = ()=>{
    if($("#name").val() == '' || $("#password").val() == ''){
        alert("Username/password can not be empty");
        return false;
    }
    return true;    
}

const getCookieValue = (name) => (
    document.cookie.match('(^|;)\\s*' + name + '\\s*=\\s*([^;]+)')?.pop() || ''
  )

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }