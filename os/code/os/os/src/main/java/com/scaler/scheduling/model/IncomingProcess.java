package com.scaler.scheduling.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomingProcess {

    private int id;
    private int arrivalTime;
    private int burstTime; // how long the process will take

    private int completeAt;

    public IncomingProcess(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    // List<ScheduleProcess> schedule (List<IncomingProcess>)

}
