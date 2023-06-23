package com.catan.democatanserver.catan.map.hex;

import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.Identifiable;
import com.catan.democatanserver.catan.map.Resource;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


public class Hex extends Identifiable {

    private final Resource resource;
    private List<HexCorner> corners;
    private List<HexEdge> edges;

    public Hex(Resource resource, List<HexCorner> corners, List<HexEdge> edges) {
        this.resource = resource;
        this.corners = corners;
        this.edges = edges;
    }

    public Resource getResource() {
        return resource;
    }

    public List<HexCorner> getCorners() {
        return corners;
    }

    public List<HexEdge> getEdges() {
        return edges;
    }
}
