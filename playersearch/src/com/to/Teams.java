package com.to;

public class Teams {
	
	private int team_id;
	private String teamName;
	private String coachName;
	
	public Teams() {
		// TODO Auto-generated constructor stub
	}

	public Teams(int team_id, String teamName, String coachName) {
		super();
		this.team_id = team_id;
		this.teamName = teamName;
		this.coachName = coachName;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	@Override
	public String toString() {
		return "Teams [team_id=" + team_id + ", teamName=" + teamName + ", coachName=" + coachName + "]";
	}
	
	
	
	
	

}
