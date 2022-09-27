package com.mytask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytask.models.entities.VehicleData;
import com.mytask.services.VehicleDataService;

@CrossOrigin(origins = "https://taufiq-vehicle-data.vercel.app", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.DELETE}

)
@RestController
@RequestMapping("/api/v1/vehicle-data")
public class VehicleDataController {

    @Autowired
    private VehicleDataService vehicleDataService;

    @PostMapping
    public VehicleData create(@RequestBody VehicleData vehicleData) {
        return vehicleDataService.save(vehicleData);
    }

    @GetMapping
    public Iterable<VehicleData> findAll() {
        return vehicleDataService.findAll();
    }

    @GetMapping("{id}")
    public VehicleData findOne(@PathVariable("id") Long id) {
        return vehicleDataService.findOne(id);
    }

    @PatchMapping
    public VehicleData update(@RequestBody VehicleData vehicleData) {
        return vehicleDataService.save(vehicleData);
    }

    @DeleteMapping("{id}")
    public void removeOne(@PathVariable("id") Long id) {
        vehicleDataService.removeOne(id);
    }
}
