package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Experiment;

import java.sql.*;
import java.util.*;

public class ExperimentJdbcDao {
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
  String CREATE_EXPERIMENT = "INSERT INTO experiments VALUES (null, ?, ?, ?, ?, ?)";
  String FIND_ALL_EXPERIMENTS = "SELECT * FROM experiments";
  String FIND_EXPERIMENT_BY_ID = "SELECT * FROM experiments WHERE id=?";
  String DELETE_EXPERIMENT = "DELETE FROM experiments WHERE id=?";
  String UPDATE_EXPERIMENT = "UPDATE experiments SET title=?, treatment_type=?, date_performed=?, notes=?, scientist_id=? WHERE id=?";

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(DRIVER);
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }

  private void closeConnection(Connection connection) throws SQLException {
    connection.close();
  }

  public Experiment findExperimentById(Integer id) throws SQLException, ClassNotFoundException {
    Experiment experiment = null;
    connection = getConnection();
    statement = connection.prepareStatement(FIND_EXPERIMENT_BY_ID);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();
    if(resultSet.next()) {
      experiment = new Experiment(
          resultSet.getString("title"),
          resultSet.getString("treatmentType"),
          resultSet.getDate("datePerformed"),
          resultSet.getString("notes"),
          resultSet.getInt("scientist_id")
      );
    }
    closeConnection(connection);
    return experiment;
  }

  public Integer deleteExperiment(Integer userId) throws SQLException, ClassNotFoundException {
    Integer rowsDeleted = 0;
    connection = getConnection();
    statement = connection.prepareStatement(DELETE_EXPERIMENT);
    statement.setInt(1, userId);
    rowsDeleted = statement.executeUpdate();
    closeConnection(connection);
    return rowsDeleted;

  }

  public Integer updateExperiment(Integer userId, Experiment experiment) throws SQLException, ClassNotFoundException {
    Integer rowsUpdated = 0;
    connection = getConnection();
    statement = connection.prepareStatement(UPDATE_EXPERIMENT);
    statement.setString(1, experiment.getTitle());
    statement.setString(2, experiment.getTreatmentType());
    statement.setDate(3, experiment.getDatePerformed());
    statement.setString(4, experiment.getNotes());
    statement.setInt(5, experiment.getScientist_id());

    rowsUpdated = statement.executeUpdate();
    closeConnection(connection);
    return rowsUpdated;


  }



  public List<Experiment> findAllExperiments() throws ClassNotFoundException, SQLException {
    List<Experiment> experiments = new ArrayList<Experiment>();
    connection = getConnection();
    statement = connection.prepareStatement(FIND_ALL_EXPERIMENTS);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      Experiment experiment = new Experiment(
          resultSet.getString("title"),
          resultSet.getString("treatmentType"),
          resultSet.getDate("datePerformed"),
          resultSet.getString("notes"),
          resultSet.getInt("scientist_id")
      );
      experiments.add(experiment);
    }
    closeConnection(connection);
    return experiments;

  }

  public Integer createExperiment(Experiment experiment)
      throws ClassNotFoundException, SQLException {

    // do your work here
    Integer rowsInserted = 0;
    connection = getConnection();
    statement = connection.prepareStatement(CREATE_EXPERIMENT);
    statement.setString(1, experiment.getTitle());
    statement.setString(2, experiment.getTreatmentType());
    statement.setDate(3, experiment.getDatePerformed());
    statement.setString(4, experiment.getNotes());
    statement.setInt(5, experiment.getScientist_id());

    rowsInserted = statement.executeUpdate();
    closeConnection(connection);
    return rowsInserted;

  }


  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    ExperimentJdbcDao dao = new ExperimentJdbcDao();

    Experiment user = dao.findExperimentById(1);
    System.out.println(user.getTitle());

    dao.deleteExperiment(12);




  }


}
