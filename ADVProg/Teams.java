package ADVProg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Teams{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // input from user number of players and teams
        int numOfPlayers = scanner.nextInt(), numOfTeams = scanner.nextInt();
        scanner.nextLine();// flush the buffer****

        // create arrayList of players and teams
        ArrayList<String> players = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();

        // input from user name of players
        for (int i = 0; i < numOfPlayers; i++)
            players.add(scanner.nextLine());

        // input from user name of teams and their players
        for (int j = 0; j < numOfTeams; j++){
            Team team = new Team(scanner.nextLine());

            // input players number of current team
            int teamPlayers = scanner.nextInt();
            scanner.nextLine();// flush the buffer

            // add players to the current team
            for (int z = 0; z < teamPlayers; z++){
                team.addPlayer(scanner.nextLine());
            }
            // add current team to the list of teams
            teams.add(team);
        }

        // create arrayList of removed teams
        ArrayList<Team> removedTeams = new ArrayList<>();

        // add teams to list of removed teams if name of its players not in players list
        for (Team team: teams){
            for (String name: team.getPlayers()){
                if (!players.contains(name))
                    removedTeams.add(team);
            }
        }

        // add teams to list of removed teams if name is duplicate
        for (Team team:teams)
            for (Team team1: teams){
                if (!team.getName().equals(team1.getName())){
                    for(String name: team.getPlayers()){
                        if (team1.getPlayers().contains(name))
                            removedTeams.add(team);
                    }
                }
            }
        // sort by name
        Collections.sort(removedTeams);

        // print team names
        for(Team team:removedTeams)
            System.out.println(team);


    }
}


class Team implements Comparable<Team>{
    //each team have name and its players
    private final String name;
    private final ArrayList<String> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    //getters***************************************
    public String getName() {
        return name;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
    //**********************************************

    public void addPlayer(String playerName){
        players.add(playerName);
    }

    @Override
    public int compareTo(Team team) {
        return this.getName().compareTo(team.getName());
    }

    @Override
    public String toString(){ return this.name; }
}