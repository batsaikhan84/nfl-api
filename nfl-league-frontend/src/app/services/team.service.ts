import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Team } from '../Models/team.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  constructor(private http: HttpClient) { }
  private baseURL = "http://localhost:3000/teams"

  fetchTeam(): Observable<Team[]> {
    return this.http.get<Team[]>(this.baseURL)
  }
  fetchTeamByID(id: number) {
    return this.http.get(`${this.baseURL}/${id}`)
  }
  createTeam(name: String, conference: String, city: String) {
    const teamData = {name: name, conference: conference, city: city}
    return this.http.post(this.baseURL, teamData)
  }
  updateTeam(id: number, name: String, conference: String, city: String) {
    const teamData = {name: name, conference: conference, city: city}
    this.http.put(`${this.baseURL}/${id}`, teamData)
  }
  deleteTeamById(id: number) {
    return this.http.delete(`${this.baseURL}/${id}`)
  }
  
}
