package com.dws.costumerservice.service;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;

import java.util.List;

public interface RegionService {

    List<Region> getRegions();

    public Region getRegion(int id);

    public RespuestaApi createRegion(Region region);

    public RespuestaApi updateRegion(Region region, int id);

    public RespuestaApi deleteRegion(int id);
}
