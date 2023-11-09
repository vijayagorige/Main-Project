package com.medicine.service;

import java.util.List;

import com.medicine.entity.MedicineRecords;

public interface MedicineService {
	List<MedicineRecords> getAllRecords();
	
	MedicineRecords saveMedicineRecord(MedicineRecords medicineRecords);
	
	MedicineRecords updateMedicineRecords(MedicineRecords medicineRecords);
	
	List<MedicineRecords> deleteMedicineRecord(Integer id);

	MedicineRecords findById(Integer id);
}
