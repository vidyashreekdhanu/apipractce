package com.ninza.hrm.pojoutility;

public class project_pojo {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	public project_pojo() {
		
	}
	public project_pojo(String createdBy,String projectName,String status,int teamSize)
	{   this.createdBy=createdBy;
	this.projectName=projectName;
	this.status=status;
		this.teamSize=teamSize;
		
	}
	public String getprojectName()
	{
		return projectName;
	}
	public void setprojectName(String projectName)
	{
		this.projectName=projectName;
	}
	public String getcreatedBy()
	{
		return createdBy;
	}
	public void setcreatedBy(String createdBy)
	{
		this.createdBy=createdBy;
	}
	public String getstatus()
	{
		return status;
	}
	public int getteamSize()
	{
		return teamSize;
	}

}
