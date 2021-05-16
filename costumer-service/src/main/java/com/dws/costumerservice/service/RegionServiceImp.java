package com.dws.costumerservice.service;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;
import com.dws.costumerservice.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImp implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getRegions() {
        return regionRepository.getRegions();
    }

    @Override
    public Region getRegion(int id) {
        return regionRepository.getRegion(id);
    }

    @Override
    public RespuestaApi createRegion(Region region) {
        return regionRepository.createRegion(region);
    }

    @Override
    public RespuestaApi updateRegion(Region region, int id) {
        return regionRepository.updateRegion(region,id);
    }

    @Override
    public RespuestaApi deleteRegion(int id) {
        return regionRepository.deleteRegion(id);
    }

}
