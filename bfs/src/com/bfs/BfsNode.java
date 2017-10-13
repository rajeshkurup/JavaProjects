package com.bfs;

import java.util.AbstractMap.SimpleEntry;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BfsNode {

	private String value;
	private boolean visited;
	private boolean blocked;
	private boolean startNode;
	private List<SimpleEntry<Integer, Integer>> path;
	
	public BfsNode(String value) {
		this.value = value;
		this.path = new ArrayList<SimpleEntry<Integer, Integer>>();
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isBlocked() {
		return blocked;
	}
	
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isStartNode() {
		return startNode;
	}

	public void setStartNode(boolean startNode) {
		this.startNode = startNode;
	}

	public List<SimpleEntry<Integer, Integer>> getPath() {
		return path;
	}

	public void setPath(List<SimpleEntry<Integer, Integer>> path) {
		this.path = path;
	}

	public void addToPath(SimpleEntry<Integer, Integer> node) {
		if(node != null) {
			this.path.add(node);
		}
	}
	
	public void addToPath(List<SimpleEntry<Integer, Integer>> nodes) {
		if(CollectionUtils.isNotEmpty(nodes)) {
			this.path.addAll(nodes);
		}
	}
	
	public void addToPath(List<SimpleEntry<Integer, Integer>> nodes, SimpleEntry<Integer, Integer> node) {
		if(CollectionUtils.isNotEmpty(nodes)) {
			this.path.addAll(nodes);
		}
		
		if(node != null) {
			this.path.add(node);
		}
	}
	
}
