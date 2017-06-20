package org.igov.model.backup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class ActGeBytearrayBackupDaoImpl implements ActGeBytearrayBackupDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(ActGeBytearrayBackupDaoImpl.class);
	
	@Value("#{sqlProperties['select.act_ge_bytearray']}")
	private String selectActGeByteArray;
	
	@Value("#{sqlProperties['insert.act_ge_bytearray_backup']}")
	private String insertActGeBytearrayBackup;
	
	@Value("#{sqlProperties['delete.act_ge_bytearray']}")
	private String deleteActGeByteArray;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public BackupResult insertActGeBytearrayBackup(ActGeBytearray actGeBytearray) {
		try {
			/*jdbcTemplate.update(insertActGeBytearrayBackup, actGeBytearray.getId_(), actGeBytearray.getRev_(),
					actGeBytearray.getName_(), actGeBytearray.getDeployment_id_(), actGeBytearray.getBytes_().getBytes(), actGeBytearray.getGenerated_());*/
			 KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator(){

				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					 PreparedStatement ps = connection.prepareStatement(
							 insertActGeBytearrayBackup, new String[]{"id_"});
			            ps.setString(1, actGeBytearray.getId_());
			            ps.setInt(2, actGeBytearray.getRev_());
			            ps.setString(3, actGeBytearray.getName_());
			            ps.setString(4, actGeBytearray.getDeployment_id_());
			            ps.setByte(5, Byte.valueOf(actGeBytearray.getBytes_()));
			            if(actGeBytearray.getGenerated_()!=null){
			            	ps.setBoolean(6, Boolean.getBoolean(actGeBytearray.getGenerated_()));
			            }else{
			            	 ps.setString(6, actGeBytearray.getGenerated_());	
			            }
			            return ps;
			        }
			    }, keyHolder);
			return BackupResult.fillResult("isnert ok", BackupResult.PRCODE_OK, BackupResult.PRSTATE_OK);
		}catch (Exception e) {
            LOG.error("FAIL insertActGeBytearrayBackup: {}", e.getMessage());
            return BackupResult.fillResult(e.getMessage(), BackupResult.PRCODE_ERROR, BackupResult.PRSTATE_ERROR);
		}

	}


	@Override
	public List<ActGeBytearray> getActGeBytearray(String condition) {
		return jdbcTemplate.query(selectActGeByteArray, new RowMapper<ActGeBytearray>(){
			
			public ActGeBytearray mapRow(ResultSet result, int rowNum) throws SQLException {
				ActGeBytearray actGeBytearray = new ActGeBytearray();
				actGeBytearray.setId_(result.getString("id_"));
				actGeBytearray.setRev_(result.getInt("rev_"));
				actGeBytearray.setName_(result.getString("name_"));
				actGeBytearray.setDeployment_id_(result.getString("deployment_id_"));
				actGeBytearray.setBytes_(Byte.toString(result.getByte("bytes_")));
				actGeBytearray.setGenerated_(result.getString("generated_"));
                return actGeBytearray;
            }
             
        }, condition);
	}


	@Override
	public BackupResult deleteActGeBytearray(String id) {
		try {
			jdbcTemplate.update(deleteActGeByteArray, id);
			return BackupResult.fillResult("delete ok", BackupResult.PRCODE_OK, BackupResult.PRSTATE_OK);
		}catch (Exception e) {
            LOG.error("FAIL insertActGeBytearrayBackup: {}", e.getMessage());
            return BackupResult.fillResult(e.getMessage(), BackupResult.PRCODE_ERROR, BackupResult.PRSTATE_ERROR);
		}

	}

	
	

}
