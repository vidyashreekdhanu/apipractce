package com.ninza.hrm.pojoutility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class exmaple {
	category cat;
	String name;
List<String> tags;
	public exmaple(category cat,String name,List<String> tags)
	{
		this.cat=cat;
		this.name=name;
		this.tags=tags;
	}
	public category getCat() {
		return cat;
	}
	public void setCat(category cat) {
		this.cat = cat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	}
	class category
	 {
		int id;
		String name;
		public category(int id,String name)
		{
			this.id=id;
			this.name=name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	 }
		class tags
		{
			int id;
			String name;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
		}
public class run_categry {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		ArrayList arr = new ArrayList();
		arr.add(20);
		arr.add("ashwini");
		
		category cate = new category(10, "vid");
		exmaple ex = new exmaple(cate, "vidyashre", arr);
		System.out.println(ex.name);

		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("./project1.json"), ex);
	}

}
