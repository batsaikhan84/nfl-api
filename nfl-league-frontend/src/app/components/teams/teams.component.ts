import { map } from 'rxjs/operators';
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
  loadedTeams: Team[] = []
  constructor(private http: HttpClient, private teamService: TeamService) { }

  ngOnInit(): void {
    this.loadTeams()
  }
  loadTeams() {
    this.teamService.fetchTeam().subscribe(response => this.loadedTeams = response)
  }
  onCreateTeam(teamData: Team) {
      this.teamService.createTeam(teamData.name, teamData.conference, teamData.city)
      this.loadTeams()
  }
  deleteTeam(id: number) {
    this.teamService.deleteTeamById(id)
  }
}
