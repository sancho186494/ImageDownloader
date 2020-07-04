package com.akh.dao;

import java.util.Arrays;

public class Image {
	private int id;
	private String name;
	private byte[] bytes;
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
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", bytes=" + Arrays.toString(bytes) + "]";
	}
	
}
