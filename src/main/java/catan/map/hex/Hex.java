package catan.map.hex;

import catan.map.HexCorner;
import catan.map.HexEdge;
import catan.map.Identifiable;
import catan.map.Resource;
import catan.serializer.HexSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@JsonSerialize(using = HexSerializer.class)
public class Hex extends Identifiable {

    private final Resource resource;
    private List<HexCorner> corners;
    private List<HexEdge> edges;

    public Hex(UUID id, Resource resource, List<HexCorner> corners, List<HexEdge> edges) {
        super(id);
        this.resource = resource;
        this.corners = corners;
        this.edges = edges;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hex hex = (Hex) o;
        return resource == hex.resource && Objects.equals(corners, hex.corners) && Objects.equals(edges, hex.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resource, corners, edges);
    }
}
