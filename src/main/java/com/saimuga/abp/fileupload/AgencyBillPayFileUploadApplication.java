package com.saimuga.abp.fileupload;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AgencyBillPayFileUploadApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AgencyBillPayFileUploadApplication.class, args);
	}
	
	   //access command line arguments
   
    
	
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("args");
		System.out.println(args[0]);
		

	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "ABPBatchInfrastructure.xml",
                "AgencyBillPayFileUploadApp.xml"
        );
        
        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
        Job job = ctx.getBean(Job.class);       

		/*
		 * jobLauncher.run(job, new JobParametersBuilder().addString("inputResource",
		 * "file:./products.zip") .addString("targetDirectory",
		 * "./importproductsbatch/").addString("targetFile", "products.txt")
		 * .addString("date", "2020-06-02").toJobParameters());
		 */
        
		jobLauncher.run(job,
				new JobParametersBuilder().addString("inputResource", "file:./products.zip")
						.addString("targetDirectory", "./importproductsbatch/").addString("targetFile", "products.txt")
						.addString("date", "2020-06sss-25").toJobParameters());
    	
    
	
	}

}
