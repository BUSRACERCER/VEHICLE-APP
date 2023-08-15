package com.works.restcontrollers;

import com.works.entities.Vehicle;
import com.works.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleRestController {
    final VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return vehicleService.list();

    }

    @PostMapping("/update")
    public ResponseEntity vehicleUpdate(@RequestBody Vehicle vehicle) {

        return vehicleService.updateVehicle(vehicle);
    }

    @GetMapping("/delete")
    public String deleteVehicle(@PathVariable Long vid, @PathVariable Long uid) {
        boolean status = vehicleService.deleteVehicle(vid, uid);
        return "redirect:/list";
    }

}
