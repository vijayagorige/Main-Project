package com.medicine.serviceimpl;


import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.medicine.entity.MedicineRecords;
import com.medicine.repository.MedicineRepository;
import com.medicine.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{
	private MedicineRepository medicineRepository;

	public MedicineServiceImpl(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}

	@Override
	public List<MedicineRecords> getAllRecords() {
		return medicineRepository.findAll();
	}

	@Override
	public MedicineRecords saveMedicineRecord(MedicineRecords medicineRecords) {
		return medicineRepository.save(medicineRecords);
	}

	@Override
	public MedicineRecords findById(Integer id) {
		return medicineRepository.findById(id).get();
	}
    
	@Override
	public MedicineRecords updateMedicineRecords(MedicineRecords medicineRecords) {
      MedicineRecords existingRecord = medicineRepository.findById(medicineRecords.getId()).get();
      existingRecord.setCompanyName(medicineRecords.getCompanyName());
      existingRecord.setMedicineName(medicineRecords.getMedicineName());
      existingRecord.setDosage(medicineRecords.getDosage());
      existingRecord.setExpiryDate(medicineRecords.getExpiryDate());
      existingRecord.setPrice(medicineRecords.getPrice());
      existingRecord.setStock(medicineRecords.getStock());
      existingRecord.setUses(medicineRecords.getUses());
      MedicineRecords updatedRecord = medicineRepository.save(existingRecord);
      return updatedRecord;
	}

	@Override
	public List<MedicineRecords> deleteMedicineRecord(Integer id) {
	    medicineRepository.deleteById(id);
		return medicineRepository.findAll();
		
	}
	
}
