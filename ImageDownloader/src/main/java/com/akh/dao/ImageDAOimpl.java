package com.akh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ImageDAOimpl implements ImageDAO {
	
	private DataSource dataSource;
	
	public ImageDAOimpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	@Override
	public List<Image> getImage() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from db";
        List<Image> listImage = jdbcTemplate.query(sql, new RowMapper<Image>() {
 
            @Override
            public Image mapRow(ResultSet rs, int rowNumber) throws SQLException {
            	Image image = new Image();
                image.setId(rs.getInt(1));
                image.setName(rs.getString(2));
                image.setBytes(rs.getBytes(3));
                return image;
            }
             
        });
        return listImage;
		
	}
}
