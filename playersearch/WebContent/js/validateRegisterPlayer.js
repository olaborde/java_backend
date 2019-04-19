/**
 * 
 */
var message ="";

function isValidPlayerRegister(){

	
	var name = document.getElementById("name").value;
	var teamName = document.getElementById("teamName").value;
	var date = document.getElementById("dob").value;
	var dob = reformatDate(date);
	var email = document.getElementById("email").value;
	var contact = document.getElementById("contact").value;
	
	
	
	var gender = "M";
	
	if(document.getElementById("gender").checked){
		gender = "F"
	}

	

	var b = false;
	if(name == "" || teamName=="" || dob=="" || email == ""){
		message = "Fields cannot be empty";
	}
	else{
        message="";
        b = true;
    }
	if(b==true){
		
		if(!isValidName(name) || !isvalidateTeamname(teamName) || !isValidDOB(dob) || !isValidContact(contact) || !isValidEmail(email) || !isValidGender(gender) ){
			
			b= false
		
		}
		else{
			b = true;
			
		}
	}
	
	document.getElementById("errMsg1").innerText=message;
	console.log(b)
	return b;
}


function isValidName(name){
	if(name.match(/[a-zA-Z]{2,20}/)){
		return true;
	}
	
	else {
		message = "Invalid username"
		return false;
		
	}
	document.getElementById("nameMessage").innerText=message;
	
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
	document.getElementById("teamNameMessage").innerText=message
}

function isValidDOB(dob){
	if( dob.match(/[0-9]{1,2}-[0-9]{2}-[0-9]{4}/) ){
		return true;
	}
	else{
		message = "Invalid date of birth";
		return false;
		
	}
	document.getElementById("dobMessage").innerText = message;
}

function isValidContact(contact){
	if(contact.length == 10 ){
		return true
	}
	else{
		message = "Invalid contact";
		return false;
		
	}
	document.getElementById("contactMessage").innerText = message;
}


function isValidEmail(email){
	if(email.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)){
		return true;
	}
	else{
		message = "Invalid email";
		return false;
		
		
	}
	document.getElementById("emailMessage").innerText = message;
}

function isValidGender(gender){
	if(gender.match(/[a-zA-Z]{1}/)){
		return true;
	}
	else{
		message = "Invalid Gende Choice";
		return false
		
	}
	document.getElementById("genderMessage").innerText = message;
	
}


function reformatDate(dob){
	
	var date = new Date(dob);
	
	
	var newDate = (date.getMonth()+1)+"-"+date.getDate() + "-" + date.getFullYear();
	
	return newDate;
}





















