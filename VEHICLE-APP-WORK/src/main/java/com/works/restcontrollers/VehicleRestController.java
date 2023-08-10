package com.works.restcontrollers;

import com.works.entities.Vehicle;
import com.works.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleRestController {
    final VehicleService vehicleService;
    private Long updateID = 0l;
    @PostMapping("/save")
    public Vehicle save(@RequestBody Vehicle vehicle){
        return vehicleService.save(vehicle);
    }

    @GetMapping("/list")
    public List<Vehicle> list(){
        return vehicleService.list();

    }

    @PostMapping("/update")
    public String vehicleUpdate(Vehicle vehicle){
        vehicle.setVid(updateID);
        vehicleService.updateVehicle(vehicle);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String deleteVehicle( @PathVariable Long vid,@PathVariable Long uid){
        boolean status = vehicleService.deleteVehicle(vid,uid);
        return "redirect:/list";
    }

}
