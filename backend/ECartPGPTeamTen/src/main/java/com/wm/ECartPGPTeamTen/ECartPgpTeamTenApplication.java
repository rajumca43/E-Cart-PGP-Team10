package com.wm.ECartPGPTeamTen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;


/**
 * r0m09yu - Raju Mummidi
 */

@SpringBootApplication
@ComponentScan("com.wm.ECartPGPTeamTen")
@Slf4j
public class ECartPgpTeamTenApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ECartPgpTeamTenApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ECartPgpTeamTenApplication.class, args);
		logger.info("Application started successfully..!");
	}

}
