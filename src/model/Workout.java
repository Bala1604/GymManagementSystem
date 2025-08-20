package model;

public class Workout {
    private int id;
    private int memberId;
    private String workoutPlan;

    public Workout(int id, int memberId, String workoutPlan) {
        this.id = id;
        this.memberId = memberId;
        this.workoutPlan = workoutPlan;
    }

    public Workout(int memberId, String workoutPlan) {
        this.memberId = memberId;
        this.workoutPlan = workoutPlan;
    }

    public int getId() { 
    	return id; 
    	}
    public int getMemberId() { 
    	return memberId; 
    	}
    public String getWorkoutPlan() { 
    	return workoutPlan; 
    	}

    @Override
    public String toString() {
        return id + " - MemberID: " + memberId + " | Plan: " + workoutPlan;
    }
}
