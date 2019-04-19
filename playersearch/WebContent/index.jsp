
<!DOCTYPE html>
<html>
<head>
<!--  Jquery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<!-- Compiled and minified CSS -->
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link type="text/css" rel="stylesheet" href="css/styles.css" />


	

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

  <nav>
    <div class="nav-wrapper">
      <a href="index.html" class="brand-logo">SearchPlayer</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="contact.html">Contact</a></li>
        <li><a class="modal-trigger" href="#modal1" >Login</a></li>
      </ul>
    </div>
   
  </nav>
    <!-- Modal Trigger -->
  

  <!-- Modal Structure -->
  <div id="modal1" class="modal login-form">
    <div class="modal-content">
    <!-- <form action="login" onsubmit="return isvalidUserCredentials()" method="post"> -->
		<form action="login" onsubmit="return isvalidUserCredentials()"
			method="post">
			<div class="input-field col s6">
				<input id="userId" name="username" type="text" class="validate">
				<label for="userId">Username</label>
			</div>
			<div class="input-field col s6">
				<input type="password" id="password" name="password" type="text"
					class="validate"> <label for="password">Password</label>
			</div>
			<!--  -->
			<input class='btn' type="submit" value="Login" /> &nbsp;&nbsp;&nbsp;
			<input class='btn' type="reset" value="Cancel" /> <br> <span
				id="errMsg" style="color: red;"></span>

			<!--  -->
		</form>
	</div>
    
   
  </div>
          

<body>

	<div class="main-menu">
		<%if(session!=null && session.getAttribute("username")!=null){%>
	
	<h1>Welcome <%=session.getAttribute("username") %></h1>

    <%} %>
		<h2>Welcome to the SearchPlayer App</h2>
		
		<div class="options" >
		    <!-- Dropdown Trigger -->
            <a class='dropdown-trigger btn' href='#' data-target='dropdown1'>Pick an option!</a>
			
			<br>
			<ul id='dropdown1'  class="dropdown-content">
				<li id="addPlayer"><a href="#">Add Player</a></li>
				<li id ="addTeam"><a href="#"> Add Team</a></li>
				<li id="viewTeams"> <a href="#"> View Teams</a></li>
				<li id="viewplayers"> <a href="#">view Players</a></li>
				<li id="searchPlayer"><a href="#"> Search Player</a></li>
			</ul>
			

		</div>

	
	</div>
	
	
	<!-- NAME	DOB	EMAIL	GENDER	CONTACT	TEAM_ID -->
	<div id="addPlayerForm">
		
	<div class="row">
    <form class="col s12" onsubmit="return isValidPlayerRegister()">
      <div class="row">
        <div class="input-field col s6">
          <input id="name" type="text" class="validate">
          <label for="name">Name</label>
          <span id="nameMessage" style="color:red;" ></span>
        </div>
        <div class="input-field col s6">
          <input id="teamName" type="text" class="validate">
          <label for="teamName">Team Name</label>
          <span id="teamNameMessage" style="color:red;" ></span>
        </div>
      </div>
  
      <div class="row">
        <div class="input-field col s6">
           <input id="dob" type="text" class="datepicker">
          <label for="dob">D.O.B</label>
          <span id="dobMessage" style="color:red;" ></span>
        </div>
        <div class="input-field col s6">
          <input id="contact" type="text" class="validate">
          <label for="contact">contact</label>
          <span id="contactMessage" style="color:red;" ></span>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate">
          <label for="email">Email</label>
          <span id="emailMessage" style="color:red;" ></span>
        </div>
      </div>
      <div class="row">
        <div class="switch">
        <label>
         M
         <input id="gender" type="checkbox">
         <span class="lever"></span>
         F
       </label>
       <span id="genderMessage" style="color:red;" ></span>
      </div>
      </div>
      <input type="submit" value="register">
<!--       <button class="btn waves-effect waves-light" type="submit" name="action">Register
    <i class="material-icons right">send</i>
  </button> -->
  <br />
  <span id="errMsg1" style="color:red;"></span>
    </form>
    
    </div>
		
</div>
	
<div id="addTeamForm">
	
	<div class="row">
		<form class="col s12" onsubmit="return isValidPlayerRegister()" >
			<div class="row">
			<div class="input-field col s6">
			<input id="addTeamName" type="text" class="validate">
			<label for="addTeamName">Team Name</label>
			<span id="teamMessage" style="color:red;" ></span>
			</div>
			<div class="input-field col s6">
			<input id="coachName" type="text" class="validate">
			<label for="coachName">Coach Name</label>
			<span id="coachMessage" style="color:red;" ></span>
			</div>
			</div> 
			<input type="submit" value="Add team" >   
			<!-- <button class="btn waves-effect waves-light" type="submit" name="action">Add Team
			<i class="material-icons right">send</i>
			</button> -->
			<br />
			<span id="addTeamErrMsg" style="color:red;"></span>
		</form>
	</div> 
</div>
	
	<div id="viewTeamsForm">
	
		<table>
        <thead>
          <tr>
              <th>Team Name</th>
              <th>Coach Name</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Miami Heat</td>
            <td>Coach OZ</td>
           
         
          </tr>
   
         
        </tbody>
      </table>
	</div>
	
	<div id="viewplayersForm">
	
		<table>
        <thead>
          <tr>
              <th>Name</th>
              <th>D.O.B</th>
              <th>Email</th>
              <th>Gender</th>
              <th>Contact</th>
              <th>Team name</th>
              <th></th>
              <th></th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Miami Heat</td>
            <td>Coach OZ</td>
            <td>09-10-1932</td>
            <td>M</td>
            <td>12345678790</td>
            <td>Miami Heat</td>
            <td><p><i class="material-icons">edit</i></p></td>
            <td><p><i class="material-icons">delete</i></p></td>
         </tr>
        
   
         
        </tbody>
      </table>
	</div>
	

	<div id="searchPlayerForm">
	
	<div class="row">
    <form class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <textarea id="textarea1" class="materialize-textarea"></textarea>
          <label for="textarea1">Textarea</label>
        </div>
      </div>
      
      <!-- select -->
      <div class="input-field col s12">
    <select>
      <option value="" disabled selected>Choose your option</option>
      <option value="id">ID</option>
      <option value="name">Name</option>
      <option value="dob">D.O.B</option>
      <option value="contact">Contact</option>
      <option value="gender">Gender</option>
      <option value="teamname">Teamname</option>
    </select>
    <label>Search by</label>
  </div>
  <a class="waves-effect waves-light btn-small">Search</a>
    </form>
    </div>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/validateRegisterPlayer.js"></script>
	
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>
	
	<script>
	</script>
</body>
</html>
