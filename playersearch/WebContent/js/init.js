(function($){
  $(function(){

    $('.sidenav').sidenav();
    $('.parallax').parallax();
    
    $('select').formSelect();
    $('.modal').modal();
    
    
    //Hide by default
    $('#addPlayerForm').hide()
    $('#addTeamForm').hide()
    $('#viewTeamsForm').hide()
    $('#viewplayersForm').hide()
    $('#updatecontactForm').hide()
    $('#searchPlayerForm').hide()
    $('#deleteForm').hide()
    
    //Click to see add player
    $('.dropdown-trigger').dropdown();
    
    $("#addPlayer").click(function(){
        $("#addPlayerForm").toggle();
    });
    
    
    //Click to see add team
    $('.dropdown-trigger').dropdown();
    
    $("#addTeam").click(function(){
        $("#addTeamForm").toggle();
    });
    
    //Click to see view team
    $('.dropdown-trigger').dropdown();
    
    $("#viewTeams").click(function(){
        $("#viewTeamsForm").toggle();
    });
    
    //Click to see view player
    $('.dropdown-trigger').dropdown();
    
    $("#viewplayers").click(function(){
        $("#viewplayersForm").toggle();
    });
    
    //Click to update contact
    $('.dropdown-trigger').dropdown();
    
    $("#updatecontact").click(function(){
        $("#updatecontactForm").toggle();
    });
    
    //Click to search player
    $('.dropdown-trigger').dropdown();
    
    $("#searchPlayer").click(function(){
        $("#searchPlayerForm").toggle();
    });
    
  //Click to search player
    $('.dropdown-trigger').dropdown();
    
    $("#delete").click(function(){
        $("#deleteForm").toggle();
    });
    
    // datepicker
    $('.datepicker').datepicker();
    $('.sidenav').sidenav();
    
    

  }); // end of document ready
})(jQuery); // end of jQuery name space



//<li id="addTeam"><a href="#"> Add Team</li>
//<li id="viewTeams"> <a href="#"> View Teams</li>
//<li id="viewplayers"> <a href="#">view Players</li>
//<li id="updatecontact"> <a href="#">Update Player Contact</li>
//<li id="searchPlayer"><a href="#"> Search Player</li>
//<li id="delete"> <a href="#"> Delete</li>