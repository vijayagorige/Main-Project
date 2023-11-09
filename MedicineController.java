package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.medicine.entity.MedicineRecords;
import com.medicine.service.MedicineService;

@RestController
public class MedicineController {
	@Autowired
	private MedicineService medicineService;

	public MedicineController(MedicineService medicineService)
	{
		super();
		this.medicineService=medicineService;
	}
	
	@GetMapping("/records")
	public ResponseEntity<List<MedicineRecords>> getAllRecords(){
	List<MedicineRecords> records= medicineService.getAllRecords();
	if(records.isEmpty()) {
	return new ResponseEntity("Sorry! records not available!",HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<List<MedicineRecords>>(records, HttpStatus.OK);
	}

	@PutMapping("/updateRecords")
	public ResponseEntity<List<MedicineRecords>> updateMedicineRecords(@RequestBody MedicineRecords medicineRecords){
	MedicineRecords newRecords= medicineService.updateMedicineRecords(medicineRecords);
	if(newRecords==null)
	{
	return new ResponseEntity("Sorry! records not available!",HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity(newRecords, HttpStatus.OK);
	}
	
	@DeleteMapping("/records/{id}")
	public ResponseEntity<List<MedicineRecords>> deleteMedicineRecord(@PathVariable("id")Integer id){
	List<MedicineRecords> deletedRecord= medicineService.deleteMedicineRecord(id);
	if(deletedRecord.isEmpty() || deletedRecord==null) {
	return new ResponseEntity("Sorry! record not available!",HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity(deletedRecord, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
    public ResponseEntity<MedicineRecords> getMedicineRecord(@PathVariable("id")Integer id){
        MedicineRecords data= medicineService.findById(id);
        if(data==null)
        {
        	return new ResponseEntity("Sorry! Data is Empty!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MedicineRecords>(data, HttpStatus.OK);
    }
	
	@PostMapping("/new")
	public ResponseEntity<MedicineRecords> insert(@RequestBody MedicineRecords medicineRecords){
	MedicineRecords add= medicineService.saveMedicineRecord(medicineRecords);
	if(add==null)
	{
	return new ResponseEntity("Sorry! medicines not available!",HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<MedicineRecords>(add, HttpStatus.OK);
	}
}
