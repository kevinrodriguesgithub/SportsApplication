package com.kevin.esd.controller;

import java.beans.PropertyEditorSupport;

import com.kevin.esd.model.Team;
import com.kevin.esd.service.TeamIPLService;

public class TeamEditor extends PropertyEditorSupport {
    private final TeamIPLService teamService;

    public TeamEditor(TeamIPLService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        int id = Integer.parseInt(text);
        Team team = teamService.getTeamDetailsById(id);	//we are passing the id and getting it's associated Team object
        setValue(team);
    }
}
