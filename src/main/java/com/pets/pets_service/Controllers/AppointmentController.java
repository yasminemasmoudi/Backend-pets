package com.pets.pets_service.Controllers;
import com.pets.pets_service.Exception.ResourceNotFoundException;
import com.pets.pets_service.Models.Appointment;
import com.pets.pets_service.Repositories.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class AppointmentController {
    @Autowired
    private AppointmentRepo appointmentRepo;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable(value = "id") Integer appointmentId)
            throws ResourceNotFoundException {

       Appointment appointment= appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("appointment not found"));
        return ResponseEntity.ok().body(appointment);
    }

    @PostMapping("/appointments")
    public Appointment createAppointment(@Valid @RequestBody Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable(value = "id") Integer appointmentId,
                                                       @Valid @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
        Appointment appointment =appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("appointment not found"));
        appointment.setId(appointmentDetails.getId());
        appointment.setDate(appointmentDetails.getDate());
        appointment.setTime(appointmentDetails.getTime());
        appointment.setVeterinary(appointmentDetails.getVeterinary());
        appointment.setDescription(appointmentDetails.getDescription());

        final Appointment updatedAppointment = appointmentRepo.save(appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/appointments/{id}")
    public Map<String, Boolean> deleteAppointment(@PathVariable(value = "id") Integer appointmentId)
            throws ResourceNotFoundException {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("appointment not found"));
        appointmentRepo.delete(appointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
