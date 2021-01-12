import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Team } from '../Models/team.model';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  constructor(private http: HttpClient) { }
  private baseURL = "http://localhost:3000/teams"

  createTeam(name: String, conference: String, city: String) {
    const teamData: Team = {name: name, conference: conference, city: city}
    this.http.post(this.baseURL, teamData).subscribe(response => response)
  }
  fetchTeam() {
    return this.http.get(this.baseURL)
  }
  fetchTeamByID(id: number) {
    return this.http.get(`${this.baseURL}/${id}`)
  }
  updateTeam(id: number, name: String, conference: String, city: String) {
    const teamData: Team = {name: name, conference: conference, city: city}
    this.http.put(`${this.baseURL}/${id}`, teamData)
  }
  deleteTeamById(id: number) {
    this.http.delete(`${this.baseURL}/${id}`)
  }
  
}
