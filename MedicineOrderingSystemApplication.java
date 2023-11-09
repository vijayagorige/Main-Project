package com.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.medicine.entity.MedicineRecords;
import com.medicine.repository.MedicineRepository;


@SpringBootApplication
public class MedicineOrderingSystemApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(MedicineOrderingSystemApplication.class, args);
		System.out.println("Order your medicines");
	}
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public void run(String...  args) throws Exception
	{
		MedicineRecords medicineRecord1=new MedicineRecords("Calpol","paracetmal","500 mg", "2024-1-22",15.04,30,"reduce fever ,body pains");
		medicineRepository.save(medicineRecord1);
		
		MedicineRecords medicineRecord2=new MedicineRecords("Advil","Ibuprofen","200 mg", "2025-8-15",50.25,30,"relief from back pain");
		medicineRepository.save(medicineRecord2);
		
		MedicineRecords medicineRecord3=new MedicineRecords("Triz","citrizen","10 mg", "2025-3-24",20.61,40," relief from cold");
		medicineRepository.save(medicineRecord3);
	}
	

}
