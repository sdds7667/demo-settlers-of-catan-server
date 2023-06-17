package com.catan.democatanserver.catan;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Hex {

    private Resource resource;
    private int number;


    @JsonIgnore
    private List<HexCorner> corners;

    @JsonIgnore
    private List<HexEdge> edges;

    public Hex(Resource resource, int number, List<HexCorner> corners, List<HexEdge> edges) {
        this.resource = resource;
        this.number = number;
        this.corners = corners;
        this.edges = edges;
    }

    public Hex(Resource resource, int number) {
        this.resource = resource;
        this.number = number;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<HexCorner> getCorners() {
        return corners;
    }

    public void setCorners(List<HexCorner> corners) {
        this.corners = corners;
    }

    public List<HexEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<HexEdge> edges) {
        this.edges = edges;
    }
}
