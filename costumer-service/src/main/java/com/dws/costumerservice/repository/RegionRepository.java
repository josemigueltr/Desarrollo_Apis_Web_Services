package com.dws.costumerservice.repository;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Region> getRegions() {
        List<Region> regions = new ArrayList<>();
        regions = jdbcTemplate.query("SELECT * FROM region;", new BeanPropertyRowMapper<Region>(Region.class));
        return regions;
    }


    public Region getRegion(int id) {
        Region region = new Region();
        String query=String.format("SELECT * FROM region WHERE id = %d ;",id);
        region = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Region>(Region.class));

        return region;
    }

    public RespuestaApi createRegion(Region region) {
        String query=String.format("INSERT INTO region (region) VALUES('%s');",region.getRegion());
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido registrada");
        return msg;
    }

    public RespuestaApi updateRegion(Region region, int id) {
        String query=String.format("UPDATE region SET region = '%s' WHERE id =  %d ;",region.getRegion(),id);
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido actualizada");
        return msg;
    }

    public RespuestaApi deleteRegion(int id) {
        String query=String.format("DELETE FROM region WHERE id = %d;",id);
        jdbcTemplate.update(query);
        RespuestaApi msg = new RespuestaApi();
        msg.setMessage("La región ha sido eliminada");
        return msg;
    }
    }



