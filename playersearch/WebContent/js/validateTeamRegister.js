/**
 * 
 */


var message = "";

function isValidPlayerRegister(){
	
	
	var teamName = document.getElementById("addTeamName").value;
	var coachName = document.getElementById("coachName").value;
	
	
	console.log(teamName);
	console.log(coachName);
	
	var b = false;
	if(teamName == "" || coachName=="" ){
		message = "Fields cannot be empty";
	}
	else{
        message="";
        b = true;
    }
	if(b==true){
		
		if( !isvalidateTeamname(teamName) || !isValidCoachName(coachName) ){
				b= false
			
			}
			else{
				b = true;
				
			}
	}
	
	
	
	document.getElementById("addTeamErrMsg").innerText=message;
	console.log(b)
	return b;
	
}


function isvalidateTeamname(teamName) {
	if(teamName.match(/[a-zA-Z]{6,15}/)){
		
		return true
	}
	else
	{
		message = "Invalid teamname"
		return false;
		
		
	}
	document.getElementById("teamMessage").innerText=message
}

function isValidCoachName(coachName){
	if(coachName.match(/[a-zA-Z]{2,20}/)){
		return true;
	}
	
	else {
		message = "Invalid coach name!"
		return false;
		
	}
	document.getElementById("coachMessage").innerText=message;
	
}












