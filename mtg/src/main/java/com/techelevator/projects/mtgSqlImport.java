package com.techelevator.projects;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class mtgSqlImport {
	
	
	public static void main(String[] args){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/MTG");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try{
			String createTable = "CREATE TABLE card ("
				+"db_card_id serial,"
				+"layout varchar(255),"
				+"name varchar(255),"
				+"manaCost varchar(255),"
				+"cmc int,"
				+"colors varchar(255) ARRAY,"
				+"type varchar(255),"
				+"types varchar(255) ARRAY,"
				+"subtypes varchar(255) ARRAY,"
				+"text varchar(765),"
				+"power varchar(255),"
				+"toughness varchar(255),"
				+"image_name varchar(255),"
				+"color_identity varchar(255) ARRAY,"
				+"CONSTRAINT pk_db_card_id PRIMARY KEY (db_card_id));";
			jdbcTemplate.update(createTable);
		}catch(Exception e){}
		try{
			jdbcTemplate.update("DELETE FROM card");
		}catch(Exception e){}

		try(Scanner fileReader = new Scanner(new File("./AllCards.json"))){
			while(fileReader.hasNextLine()){
				String layout = null;
				String name = null;
				String manaCost = null;
				int cmc = 0;
				String[] colors = null;
				String type = null;
				String[] types = null;
				String[] subtypes = null;
				String text = null;
				String power = null;
				String toughness = null;
				String imageName = null;
				String[] colorIdentity = null;
			
				while(fileReader.hasNextLine()){
					String line = fileReader.nextLine();
					if(line.contains("layout")){
						while(true){
							line = fileReader.nextLine();
							String[] split = line.split("\"");
							if(split[1].equals("layout")){
								layout = split[3];
							}
							if(split[1].equals("name")){
								name = split[3];
							}
							if(split[1].equals("manaCost")){
								manaCost = split[3];
							}
							if(split[1].equals("cmc")){
								cmc = Integer.parseInt(split[3]);
							}
							if(split[1].equals("colors")){
								colors = arrayReturner(fileReader);
							}
							if(split[1].equals("type")){
								type = split[3];
							}
							if(split[1].equals("types")){
								types = arrayReturner(fileReader);
							}
							if(split[1].equals("subtypes")){
								subtypes = arrayReturner(fileReader);
							}
							if(split[1].equals("text")){
								type = split[3];
							}
							
							
						}
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("Where the file at?");
			e.printStackTrace();
		}
		
		
		
		
		
		
		return;
	}
}
