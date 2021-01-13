import { TeamService } from './../../services/team.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team-detail',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDetailComponent implements OnInit {
  constructor(private teamService: TeamService) { }

  ngOnInit(): void {
  }
  loadTeamById(id: any) {
    this.teamService.fetchTeamByID(id).subscribe(response => console.log(response))
  }

}
