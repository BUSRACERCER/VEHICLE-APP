package com.works.services;

import com.works.entities.Vehicle;
import com.works.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sun.security.mscapi.CPublicKey;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
    final VehicleRepository vehicleRepository;
     public Vehicle save(Vehicle vehicle){
         return vehicleRepository.save(vehicle);
     }

     public List<Vehicle> list(){
         return vehicleRepository.findAll();
     }

     public boolean updateVehicle( Vehicle vehicle){
         try {
             vehicleRepository.saveAndFlush(vehicle);
             return true;
         }catch (Exception ex){
             return false;
         }

     }

     public boolean deleteVehicle(Long vid, Long uid ){
        try{
            boolean status = vehicleRepository.existsByVidEqualsAndUidEquals(vid,uid);
            if (status){
                vehicleRepository.deleteById(vid);
                return true;
            }

        }catch (Exception ex){
            System.err.println("Vehicle Delete Fail");
        }
        return  false;


     }
}
