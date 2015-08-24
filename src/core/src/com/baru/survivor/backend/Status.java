package com.baru.survivor.backend;

import java.util.ArrayList;
import java.util.List;

import com.baru.survivor.backend.agents.Agent;
import com.baru.survivor.backend.map.Terrain;
import com.baru.survivor.backend.map.TerrainGenerator;
import com.baru.survivor.backend.resources.Resource;

public class Status {

	private Terrain terrainManager = new Terrain();
	private List<Agent> agentManager = new ArrayList<Agent>();
	private List<Resource> resourceManager = new ArrayList<Resource>();

	public void generateMap() {
		terrainManager = (new TerrainGenerator()).generateMap();
	}

	public void addResources() {
		// TODO Auto-generated method stub
		
	}

	public void addAgents(int agentsNum) {
		while (agentsNum > 0){
			Agent newAgent = new Agent();
			if (terrainManager.canSpawn(newAgent.x(), newAgent.y())){
				agentManager.add(newAgent);
				agentsNum--;
			}
		}		
	}

	public Terrain getTerrain() {
		return terrainManager;
	}
	
	public List<Agent> getAgents() {
		return agentManager;
	}

	public List<Resource> getResources() {
		return resourceManager;
	}
	
	public void nextState(){
		
	}

	public void create() {
		// Start simulation
		generateMap();
		addResources();
		addAgents(5);
	}

	public Agent getAgentAt(int x, int y) {
		for (Agent agent: agentManager){
			if(agent.x() == x && agent.y() == y){
				return agent;
			}
		}
		return null;
	}

}