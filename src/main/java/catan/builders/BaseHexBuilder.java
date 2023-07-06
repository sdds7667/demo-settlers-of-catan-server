package catan.builders;

import catan.map.HexCorner;
import catan.map.HexEdge;
import catan.map.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public abstract class BaseHexBuilder implements HexBuilder {
    Logger logger;

    protected UUID id;
    protected Resource resource;
    protected List<HexCorner> corners;
    protected List<HexEdge> edges;

    public BaseHexBuilder() {
        logger = Logger.getLogger(BaseHexBuilder.class.getName());
        reset();
    }


    @Override
    public void reset() {
        resource = null;
        id = UUID.randomUUID();

        if (corners == null)
            corners = new ArrayList<>();
        else
            corners.clear();
        for (int i = 0; i < 6; i++)
            corners.add(null);

        if (edges == null)
            edges = new ArrayList<>();
        else
            edges.clear();

        for (int i = 0; i < 6; i++)
            edges.add(null);
    }

    @Override
    public BaseHexBuilder setCorner(int index, HexCorner corner) {
        if (index < 0 || index > 5) throw new IllegalArgumentException("Corner index must be between 0 and 5");
        if (corner == null) throw new IllegalArgumentException("Corner cannot be null");
        if (corners.get(index) != null) logger.warning("Overwriting corner " + index);
        corners.set(index, corner);
        return this;
    }

    @Override
    public BaseHexBuilder setEdge(int edgeIndex, HexEdge edge) {
        if (edgeIndex < 0 || edgeIndex > 5) throw new IllegalArgumentException("Edge index must be between 0 and 5");
        if (edge == null) throw new IllegalArgumentException("Corner cannot be null");
        if (edges.get(edgeIndex) != null) logger.warning("Overwriting edge " + edgeIndex);
        edges.set(edgeIndex, edge);
        return this;
    }

    public boolean isCornerSet(int index) {
        if (index < 0 || index > 5) throw new IllegalArgumentException("Corner index must be between 0 and 5");
        return corners.get(index) != null;
    }

    public boolean isEdgeSet(int index) {
        if (index < 0 || index > 5) throw new IllegalArgumentException("Edge index must be between 0 and 5");
        return edges.get(index) != null;
    }

    public HexCorner getCorner(int index) {
        if (index < 0 || index > 5) throw new IllegalArgumentException("Corner index must be between 0 and 5");
        return corners.get(index);
    }

    public HexEdge getEdge(int index) {
        if (index < 0 || index > 5) throw new IllegalArgumentException("Edge index must be between 0 and 5");
        return edges.get(index);
    }

    public UUID getId() {
        return id;
    }

    public BaseHexBuilder setId(UUID id) {
        if (id == null) throw new IllegalArgumentException("Id cannot be null");
        this.id = id;
        return this;
    }

    public Resource getResource() {
        return resource;
    }

    public BaseHexBuilder setResource(Resource resource) {
        if (resource == null) throw new IllegalArgumentException("Resource cannot be null");
        this.resource = resource;
        return this;
    }


}
