import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Team } from '../Models/team.model';
import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  constructor(private http: HttpClient) { }
  baseURL = "http://localhost:3000/teams"

  createTeam(name: String, conference: String, city: String) {
    const teamData: Team = {name: name, conference: conference, city: city}
    return this.http.post(this.baseURL, teamData)
  }
  fetchTeam() {
    return this.http.get(this.baseURL)
}
