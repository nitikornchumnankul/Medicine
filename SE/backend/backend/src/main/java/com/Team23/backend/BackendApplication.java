package com.Team23.backend;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import com.Team23.backend.Repository.DrugRegistrationRepository;
import com.Team23.backend.Repository.TypesOfDosageFormsRepository;
import com.Team23.backend.Repository.TypesOfDrugsRepository;

import java.util.stream.Stream;

import com.Team23.backend.Entity.Disease;
import com.Team23.backend.Entity.DrugRegistration;
import com.Team23.backend.Entity.*;
import com.Team23.backend.Entity.TypesOfDosageForms;
import com.Team23.backend.Entity.TypesOfDrugs;
import com.Team23.backend.Repository.DiseaseRepository;
import com.Team23.backend.Repository.DrugRepository;
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	CharacterEncodingFilter characterEncodingFilter(){
		CharacterEncodingFilter filter =new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init( DrugRepository             drugRepository,         TypesOfDrugsRepository       typesOfDrugsRepository,
                            DrugRegistrationRepository drugRegistrationRepository, TypesOfDosageFormsRepository typesOfDosageFormsRepository,
                            DiseaseRepository          diseaseRepository){ 
    return args->{
		

		Stream.of("ยาสามัญ","ยาสามัญประจำบ้าน","ยาอันตราย","ยาควบคุมพิเศษ","ผลิตภัณฑ์เสริมอาหาร").forEach(typesOfDrugsName -> {
		TypesOfDrugs typesOfDrugs = new TypesOfDrugs();
		typesOfDrugs.setTypesOfDrugsName(typesOfDrugsName);
		typesOfDrugsRepository.save(typesOfDrugs);
		});
		typesOfDrugsRepository.findAll().forEach(System.out::println);


		Stream.of("ทะเบียนยาแผนปัจจุบันสำหรับมนุษย์ชนิดแคปซูล","ทะเบียนยาแผนปัจจุบันสำหรับมนุษย์ชนิดเม็ด").forEach(drugRegistrationName -> {
		DrugRegistration drugRegistration = new DrugRegistration();
		drugRegistration.setDrugRegistrationName(drugRegistrationName);
		drugRegistrationRepository.save(drugRegistration);
		});
		drugRegistrationRepository.findAll().forEach(System.out::println);


		Stream.of("เม็ดสี่เหลี่ยม","เม็ดสามเหลี่ยม","เม็ดวงกลม","เม็ดวงรี","เม็ดแคปซูล","น้ำ").forEach(typesOfDosageFormsName -> {
		TypesOfDosageForms typesOfDosageForms = new TypesOfDosageForms();
		typesOfDosageForms.setTypesOfDosageFormsName(typesOfDosageFormsName);
		typesOfDosageFormsRepository.save(typesOfDosageForms);
		});
		typesOfDosageFormsRepository.findAll().forEach(System.out::println);

		Stream.of("ปวดหัว","ปวดท้อง","เจ็บคอ").forEach(diseaseName -> {
		Disease disease = new Disease();
		disease.setDiseaseName(diseaseName);
		diseaseRepository.save(disease);
		});
		diseaseRepository.findAll().forEach(System.out::println);
	};
		
	}

}

