var message ="";

function isvalidUserCredentials(){
	
	console.log("credkhgjhghjgjhgjhgjhgjh")
    var userId = document.getElementById("userId").value;
    var password = document.getElementById("password").value;

    var b = false;
    
    

    if(userId=="" || password==""){
        message = " userid and password are required";
    }
    else{
        message="";
        b = true;
    }
    
    if(b==true){
    	b=isValidUserId(userId);
    	if(b==true){
    		
    		b = isValidpassword(password);
    	}
    }
    document.getElementById("errMsg").innerText=message;

    return b;
}


function isValidUserId(userId){
	var b1 = false;
	console.log("Userrrrid")
	
	if(userId.match(/^[a-zA-Z]{3}[0-9]{7}$/)){
		
		b1 = true;
		
		
	}
	else{
		message  = "Invalid userID"
	}
	
	return b1;
	
}

function isValidpassword(password){
	console.log("passworddddd")
	var b1 = false;
	console.log("Invalidddpass");
	if(password.match(/^[a-z]{4}[0-9]{4}$/)){
		b1 = true
	}
	else{
		message="Invalid password";
	}
	return b1;
}