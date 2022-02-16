package service;

import entity.Activity;
import exception.ActivityDatabaseOperationException;
import lombok.extern.slf4j.Slf4j;
import utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ActivityServiceImpl implements ActivityService {
    
    private static final String INSERT_ACTIVITY_QUERY = "insert into activities(username, discipline, place, time) values (?, ?, ?,?)";
    
    private static final String GET_ACTIVITY_BY_ID_QUERY = "select * from activities where id=?";
    
    private static final String UPDATE_ACTIVITY_BY_ID_QUERY = "update activities set discipline=?, place=?, time=? where id=?";
    
    private static final String DELETE_ACTIVITY_BY_ID_QUERY = "delete from activities where id=?";
    
    private static final String GET_ALL_ACTIVITIES_QUERY = "select * from activities";
    
    private final Connection connection;
    
    public ActivityServiceImpl() {
        this.connection = DbUtil.getConnection();
    }
    
    @Override
    public Activity createActivity(Activity activity) throws ActivityDatabaseOperationException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACTIVITY_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, activity.getUsername());
            preparedStatement.setString(2, activity.getDiscipline());
            preparedStatement.setString(3, activity.getPlace());
            preparedStatement.setTimestamp(4, activity.getTime());
            preparedStatement.executeUpdate();
            try ( ResultSet generatedKeys = preparedStatement.getGeneratedKeys() ) {
                if ( generatedKeys.next() ) {
                    activity.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            return activity;
        } catch ( SQLException e ) {
            throw new ActivityDatabaseOperationException("Error during inserting new activity into database.", e);
        }
    }
    
    @Override
    public Activity getActivity(Long id) throws ActivityDatabaseOperationException {
        try {
            Activity activity = null;
            PreparedStatement preparedStatement = connection.
                    prepareStatement(GET_ACTIVITY_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            if ( rs.next() ) {
                activity = new Activity();
                activity.setId(rs.getLong("id"));
                activity.setUsername(rs.getString("username"));
                activity.setDiscipline(rs.getString("discipline"));
                activity.setPlace(rs.getString("place"));
                activity.setTime(rs.getTimestamp("time"));
            }
            return activity;
        } catch ( SQLException e ) {
            throw new ActivityDatabaseOperationException("Error during getting activity with id: " + id, e);
        }
    }
    
    @Override
    public void updateActivity(Long id, Activity activity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACTIVITY_BY_ID_QUERY);
            preparedStatement.setString(1, activity.getDiscipline());
            preparedStatement.setString(2, activity.getPlace());
            preparedStatement.setTimestamp(3, activity.getTime());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch ( SQLException e ) {
            throw new ActivityDatabaseOperationException("Error during updating activity with id: " + id, e);
        }
    }
    
    @Override
    public boolean deleteActivity(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACTIVITY_BY_ID_QUERY);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch ( SQLException e ) {
            throw new ActivityDatabaseOperationException("Error during deleting activity with id: " + id, e);
        }
    }
    
    @Override
    public List<Activity> getAllActivities() {
        try {
            List<Activity> activities = new ArrayList<>();
            PreparedStatement preparedStatement = connection.
                    prepareStatement(GET_ALL_ACTIVITIES_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            
            while ( rs.next() ) {
                Activity activity = new Activity();
                activity.setId(rs.getLong("id"));
                activity.setUsername(rs.getString("username"));
                activity.setDiscipline(rs.getString("discipline"));
                activity.setPlace(rs.getString("place"));
                activity.setTime(rs.getTimestamp("time"));
                activities.add(activity);
            }
            return activities;
        } catch ( SQLException e ) {
            throw new ActivityDatabaseOperationException("Error during getting activities.", e);
        }
    }
    
}
