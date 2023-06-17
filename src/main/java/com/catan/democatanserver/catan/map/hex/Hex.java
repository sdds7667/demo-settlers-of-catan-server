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

    public Hex(Resource resource) {
        this.resource = resource;
        this.corners = new ArrayList<>();
        this.edges = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.corners.add(null);
            this.edges.add(null);
        }
    }

    public Resource getResource() {
        return resource;
    }


}
