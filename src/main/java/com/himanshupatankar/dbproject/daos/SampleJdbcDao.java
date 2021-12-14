package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Sample;

import java.sql.*;
import java.util.*;

public class SampleJdbcDao {
  static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String HOST = "localhost:3306";
  static final String SCHEMA = "db_design_project";
  static final String CONFIG = "serverTimezone=UTC";
  static final String URL =
      "jdbc:mysql://"+HOST+"/"+SCHEMA+"?"+CONFIG;
  static final String USERNAME = "root";
  static final String PASSWORD = "password";

  static Connection connection = null;
  static PreparedStatement statement = null;
  String CREATE_SAMPLE = "INSERT INTO samples VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
  String FIND_ALL_SAMPLES = "SELECT * FROM samples";
  String FIND_SAMPLE_BY_ID = "SELECT * FROM samples WHERE id=?";
  String DELETE_SAMPLE = "DELETE FROM samples WHERE id=?";
  String UPDATE_SAMPLE = "UPDATE sample SET name=?, organism=?, tissueOrigin=?, dnaSequence=?, disease=?, vendor=?, notes=?, experiment_id=? WHERE id=?";

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(DRIVER);
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }

  private void closeConnection(Connection connection) throws SQLException {
    connection.close();
  }

  public Sample findSampleById(Integer id) throws SQLException, ClassNotFoundException {
    Sample sample = null;
    connection = getConnection();
    statement = connection.prepareStatement(FIND_SAMPLE_BY_ID);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();
    if(resultSet.next()) {
      sample = new Sample(
          resultSet.getString("name"),
          resultSet.getString("organism"),
          resultSet.getString("tissueOrigin"),
          resultSet.getString("dnaSequence"),
          resultSet.getString("disease"),
          resultSet.getString("vendor"),
          resultSet.getString("notes"),
          resultSet.getInt("experiment_id")
      );
    }
    closeConnection(connection);
    return sample;
  }

  public Integer deleteSample(Integer sampleID) throws SQLException, ClassNotFoundException {
    Integer rowsDeleted = 0;
    connection = getConnection();
    statement = connection.prepareStatement(DELETE_SAMPLE);
    statement.setInt(1, sampleID);
    rowsDeleted = statement.executeUpdate();
    closeConnection(connection);
    return rowsDeleted;

  }

  public Integer updateSample(Integer sampleId, Sample sample) throws SQLException, ClassNotFoundException {
    Integer rowsUpdated = 0;
    connection = getConnection();
    statement = connection.prepareStatement(UPDATE_SAMPLE);
    statement.setString(1, sample.getName());
    statement.setString(2, sample.getOrganism());
    statement.setString(3, sample.getTissueOrigin());
    statement.setString(4, sample.getDnaSequence());
    statement.setString(5, sample.getDisease());
    statement.setString(6, sample.getVendor());
    statement.setString(7, sample.getNotes());
    statement.setInt(8, sample.getExperiment_id());
    rowsUpdated = statement.executeUpdate();
    closeConnection(connection);
    return rowsUpdated;


  }



  public List<Sample> findAllSamples() throws ClassNotFoundException, SQLException {
    List<Sample> samples = new ArrayList<Sample>();
    connection = getConnection();
    statement = connection.prepareStatement(FIND_ALL_SAMPLES);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      Sample sample = new Sample(
          resultSet.getString("name"),
          resultSet.getString("organism"),
          resultSet.getString("tissueOrigin"),
          resultSet.getString("dnaSequence"),
          resultSet.getString("disease"),
          resultSet.getString("vendor"),
          resultSet.getString("notes"),
          resultSet.getInt("experiment_id")
      );
      samples.add(sample);
    }
    closeConnection(connection);
    return samples;

  }

  public Integer createSample(Sample sample)
      throws ClassNotFoundException, SQLException {

    // do your work here
    Integer rowsInserted = 0;
    connection = getConnection();
    statement = connection.prepareStatement(CREATE_SAMPLE);
    statement.setString(1, sample.getName());
    statement.setString(2, sample.getOrganism());
    statement.setString(3, sample.getTissueOrigin());
    statement.setString(4, sample.getDnaSequence());
    statement.setString(5, sample.getDisease());
    statement.setString(6, sample.getVendor());
    statement.setString(7, sample.getNotes());
    statement.setInt(8, sample.getExperiment_id());

    rowsInserted = statement.executeUpdate();
    closeConnection(connection);
    return rowsInserted;

  }


  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    SampleJdbcDao dao = new SampleJdbcDao();







  }


}
