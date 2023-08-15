package com.works.services;

import com.works.configs.Rest;
import com.works.entities.Vehicle;
import com.works.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {
    final VehicleRepository vehicleRepository;

    public ResponseEntity save(Vehicle vehicle) {
        try {
            vehicleRepository.save(vehicle);
            Rest rest = new Rest(true, vehicle);
            return new ResponseEntity<>(rest, HttpStatus.OK);

        } catch (Exception ex) {
            Rest rest = new Rest(false, ex.getMessage());
            return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity list() {
        List<Vehicle> ls = vehicleRepository.findAll();
        Rest rest = new Rest(true, ls);
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    public ResponseEntity updateVehicle(Vehicle vehicle) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle.getVid());
        if (optionalVehicle.isPresent()) {
            vehicleRepository.saveAndFlush(vehicle);
            Rest res = new Rest(true, vehicle);
            return new ResponseEntity(res, HttpStatus.OK);
        }
        Rest res = new Rest(false, vehicle);
        return new ResponseEntity(res, HttpStatus.BAD_REQUEST);

         /* Bu kısım ResponseEntity kullanmasaydım bunu kullanabilirdim.
             // public boolean updateVehicle( Vehicle vehicle){

         try {
             vehicleRepository.saveAndFlush(vehicle);
             return true;
         }catch (Exception ex){
             return false;
         }*/

    }

    public boolean deleteVehicle(Long vid, Long uid) {
        //Bu kısmıda ResponseEntitiy yaparak geri gönderebilirdim ama farklılıkolsun istedim.
        try {
            boolean status = vehicleRepository.existsByVidEqualsAndUidEquals(vid, uid);
            if (status) {
                vehicleRepository.deleteById(vid);
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Vehicle Delete Fail");
        }
        return false;


    }
}
