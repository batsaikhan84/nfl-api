import { Team } from './../../Models/team.model';
import { TeamService } from './../../services/team.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {
  loadedTeams: Team[] = []
  loadedTeam: any
  constructor(private http: HttpClient, private teamService: TeamService) { }

  ngOnInit(): void {
    this.loadTeams()
  }
  loadTeams() {
    this.teamService.fetchTeam().subscribe(response => this.loadedTeams = response)
  }
  onCreateTeam(teamData: Team) {
      this.teamService.createTeam(teamData.name, teamData.conference, teamData.city).subscribe(response => {console.log(response), this.loadTeams()})
  }
  deleteTeam(id: any) {
    this.teamService.deleteTeamById(id).subscribe(response => {console.log(response), this.loadTeams()})
  }
  loadTeamById(id: any) {
    this.teamService.fetchTeamByID(id).subscribe(response => {this.loadedTeam = response, console.log(response)})
  }
}
