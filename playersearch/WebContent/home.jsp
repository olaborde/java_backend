<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<sql:setDataSource var = "dataSource" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "lms"  password = "password" scope="session"/>
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
    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <a href="home.jsp" class="brand-logo">SearchPlayer</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="contact.html">Contact</a></li>
        
        <li><a class="modal-trigger" href="#modal2" >Sign Up</a></li>
        <li><a class="modal-trigger" href="#modal1" >Login</a></li>
        <%if(session!=null && session.getAttribute("username")!=null){%>
	
		<li>Welcome, <%=session.getAttribute("username") %></li>
		<li><a href="logout">Logout</a></li>

   		 <%} %>
      </ul>
    </div>
   
  </nav>
  
   <ul class="sidenav" id="mobile-demo">
     <li><a href="contact.html">Contact</a></li>
        <li><a class="modal-trigger" href="#modal1" >Login</a></li>
        <%if(session!=null && session.getAttribute("username")!=null){%>
	
		<li>Welcome, <%=session.getAttribute("username") %></li>
		<li><a href="logout">Logout</a></li>

   		 <%} %>
  </ul>
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
  
  <!-- Signup modal  -->
  
  <div id="modal2" class="modal login-form">
  <div class="modal-content">
  <form action=""  method="post">
  
  	<div class="input-field col s6">
  	<input id="signupuserId" name="username" type="text"  >
  	<label for="signupuserId">Enter your player ID</label>
  	</div>
  	
  	<div class="input-field col s6">
	<input type="password" id="signuppassword1" name="password" type="text"
	 class="validate"> <label for="signuppassword1">Password</label>
	</div>
	
	<div class="input-field col s6">
	<input type="password" id="signuppassword2" name="v_password" type="text" class="validate"> 
	<label for="signuppassword">confirm Password</label>
	</div>
	<!-- <input class='btn' type="submit" name="signup" value="signup" /> -->
	<input type="submit" value="Signup" name="signup">
	<!--  &nbsp;&nbsp;&nbsp; -->
	
  	
  </form>
  
  <%if(request.getParameter("signup")!=null){ %>
    
    	<jsp:useBean id="user" class="com.model.User" scope="session"></jsp:useBean>
    	
    	<jsp:setProperty property="*" name="user"/>
    
    <% response.sendRedirect("signup");
    } %>
  
  </div>
  </div>
  
  <!-- End of SignUp modal -->
          

<body>

	<div class="main-menu">
		
		<h2>Welcome to the SearchPlayer App</h2>
		
		<%-- player name ${player.name}  --%>
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
	<!-- Beginning of JSTL Query for grabbing teamname from db  -->
	

     <sql:query var="teamss" dataSource = "${dataSource}">
            SELECT teamname from teams
     </sql:query>
     <!-- END of JSTL -->		
	<div class="row">
    <form class="col s12" onsubmit="return isValidPlayerRegister()" action="" method="post" >
      <div class="row">
        <div class="input-field col s6">
          <input id="name" name="name" type="text" class="validate">
          <label for="name">Name</label>
          <span id="nameMessage" style="color:red;" ></span>
        </div>
      <!--   <div class="input-field col s6">
          <input id="teamName" name="teamname" type="text" class="validate">
          <label for="teamName">Team Name</label>
          
          <span id="teamNameMessage" style="color:red;" ></span>
        </div> -->
        <div class="input-field col s6">
       	<select name="teamname" >
       	<option value="" disabled selected>Choose a team</option>
       	<c:forEach var="row" items="${teamss.rows}">
       
        <option> <c:out value="${row.teamname }" /> </option>
        </c:forEach>
      
        </select>
       <label>Materialize Select</label>
       </div>
        
        
      </div>
  
      <div class="row">
        <div class="input-field col s6">
           <input id="dob" name="t_dob" type="text" class="datepicker">
          <label for="dob">D.O.B</label>
          <span id="dobMessage" style="color:red;" ></span>
        </div>
        <div class="input-field col s6">
          <input id="contact" name="contact" type="text" class="validate">
          <label for="contact">contact</label>
          <span id="contactMessage" style="color:red;" ></span>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" name="email" type="email" class="validate">
          <label for="email">Email</label>
          <span id="emailMessage" style="color:red;" ></span>
        </div>
      </div>
      <div class="row">
        <div class="switch">
        <label>
         M
         <input id="gender1" name="gender" type="checkbox">
         <span class="lever"></span>
         F
       </label>
       <span id="genderMessage" style="color:red;" ></span>
      </div>
      </div>
      
      <input type="submit" value="Register" name="register">
      
<!--       <button class="btn waves-effect waves-light" type="submit" name="action">Register
    <i class="material-icons right">send</i>
  </button> -->
  <br />
  <span id="errMsg1" style="color:red;"></span>
    </form>
    <%if(request.getParameter("register")!=null){ %>
    
    	<jsp:useBean id="player" class="com.to.Player" scope="session"></jsp:useBean>
    	
    	<jsp:setProperty property="*" name="player"/>
    
    <% response.sendRedirect("register");
    } %>
    
    </div>
   
		
</div>
	
<div id="addTeamForm">
	
	<div class="row">
		<form class="col s12" action="" method="post" >
			<div class="row">
			<div class="input-field col s6">
			<input id="addTeamName" name="teamName" type="text" class="validate">
			<label for="addTeamName">Team Name</label>
			<span id="teamMessage" style="color:red;" ></span>
			</div>
			<div class="input-field col s6">
			<input id="coachName" name="coachName" type="text" class="validate">
			<label for="coachName">Coach Name</label>
			<span id="coachMessage" style="color:red;" ></span>
			</div>
			</div> 
			<input type="submit" name="regsiterTeam" value="Add team" >   
			<!-- <button class="btn waves-effect waves-light" type="submit" name="action">Add Team
			<i class="material-icons right">send</i>
			</button> -->
			<br />
			<span id="addTeamErrMsg" style="color:red;"></span>
		</form>
		<%if(request.getParameter("regsiterTeam")!=null){ %>
    
    	<jsp:useBean id="teams" class="com.to.Teams" scope="session"></jsp:useBean>
    	
    	<jsp:setProperty property="*" name="teams"/>
    
    <% response.sendRedirect("regsiterTeam");
    } %>
	</div> 
</div>
	
	<div id="viewTeamsForm">
		<sql:query var="teamss" dataSource = "${dataSource}">
           
			SELECT TEAMNAME, COACHNAME FROM TEAMS
       </sql:query>
	
		<table>
        <thead>
          <tr>
              <th>Team Name</th>
              <th>Coach Name</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach var="row" items="${teamss.rows}">
          <tr>
          	<td><c:out value="${row.TEAMNAME }" /></td>
          	<td><c:out value="${row.COACHNAME }" /></td>
          </tr>
   		</c:forEach>
         
        </tbody>
      </table>
	</div>
	
	<div id="viewplayersForm">
	<sql:query var="teamss" dataSource = "${dataSource}">
            select player.id, player.name, player.dob, player.email, player.gender, player.contact, teams.TEAMNAME 
			FROM player 

			INNER JOIN teams

			On player.TEAM_ID=teams.TEAM_ID
			
     </sql:query>
    
     <sql:query var="logins" dataSource = "${dataSource}" >
     	select username from playerlogin
     </sql:query>
     <c:forEach var="row" items="${logins.rows}">
     	
     	<c:out value="${row.username}" />
     </c:forEach>
	
		<table>
        <thead>
          <tr>
              <th>Name</th>
              <th>D.O.B</th>
              <th>Email</th>
              <th>Gender</th>
              <th>Contact</th>
              <th>Team name</th>
              <th>Edit</th>
              <th>Delete</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach var="row" items="${teamss.rows}">
          <form>
	          <tr>
	            <td><c:out value="${row.name }" /></td>
	            <td><c:out value="${row.dob }" /></td>
	            <td><c:out value="${row.email }" /></td>
	            <td><c:out value="${row.gender }" /></td>
	            <td><c:out value="${row.contact }" /></td>
	            <td><c:out value="${row.TEAMNAME }" /></td>
	            <td><c:out value="${row.id }" /></td>
	            <td><a href="update.jsp?id=${row.id }&contact=${row.contact }"  ><button type="button"><i class="material-icons">edit</i></button></a></td>
	            <td><a href="delete.jsp?id=${row.id }" ><button type="button"><i class="material-icons">delete</i></button></a></td>
	         </tr>
         </form>
         </c:forEach>
        
   
         
        </tbody>
      </table>
	</div>
	

	<div id="searchPlayerForm">
	
	<div class="row">
    <form action="search" class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <textarea id="textarea1" class="materialize-textarea" name="searchValue" ></textarea>
          <label for="textarea1">Search Criteria</label>
        </div>
      </div>
      
      <!-- select -->
      <div class="input-field col s12">
    <select name="criteria">
      <option value="0" disabled selected>Search Criteria:</option>
      <option value="1">ID</option>
      <option value="2">Name</option>
      <option value="3">By Email</option>
      <option value="4">D.O.B</option>
      <option value="5">Contact</option>
      <option value="6">Gender</option>
      <option value="7">Teamname</option>
    </select>
    <label>Search by</label>
  </div>
 <!--  <a class="waves-effect waves-light btn-small">Search</a> -->
  <input class="waves-effect waves-light btn-small" type="submit" value="Search">
  
    </form>
    
    <%if(request.getAttribute("errorMessage")!=null){ %>
<span style="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%
request.removeAttribute("errorMessage");

} %>
    
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
