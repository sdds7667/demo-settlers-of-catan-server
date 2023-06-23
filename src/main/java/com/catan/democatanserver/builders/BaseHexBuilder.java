package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class BaseHexBuilder implements HexBuilder {
    Logger logger;

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
        if (corners == null) {
            corners = new ArrayList<>();
            for (int i = 0; i < 6; i++)
                corners.add(null);
        } else {
            corners.clear();
        }
        if (edges == null) {
            edges = new ArrayList<>();
            for (int i = 0; i < 6; i++)
                edges.add(null);
        } else {
            edges.clear();
        }
    }

    @Override
    public void setCorner(int index, HexCorner corner) {
        if (index < 0 || index > 5) throw new IllegalArgumentException("Corner index must be between 0 and 5");
        if (corner == null) throw new IllegalArgumentException("Corner cannot be null");
        if (corners.get(index) != null) logger.warning("Overwriting corner " + index);
        corners.set(index, corner);
    }

    @Override
    public void setEdge(int edgeIndex, HexEdge edge) {
        if (edgeIndex < 0 || edgeIndex > 5) throw new IllegalArgumentException("Edge index must be between 0 and 5");
        if (edge == null) throw new IllegalArgumentException("Corner cannot be null");
        if (edges.get(edgeIndex) != null) logger.warning("Overwriting edge " + edgeIndex);
        edges.set(edgeIndex, edge);
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        if (resource == null) throw new IllegalArgumentException("Resource cannot be null");
        this.resource = resource;
    }


}
