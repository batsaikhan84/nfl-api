import { TeamService } from './../../services/team.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Team } from '../../Models/team.model'

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {
  constructor(private http: HttpClient, private teamService: TeamService) { }

  ngOnInit(): void {
    this.teamService.fetchTeam().subscribe(response => response)
  }
  onFetchTeams() {
    this.teamService.fetchTeam()
  }
  onCreateTeam(teamData: Team) {
      this.teamService.createTeam(teamData.name, teamData.conference, teamData.city)
  }
}
