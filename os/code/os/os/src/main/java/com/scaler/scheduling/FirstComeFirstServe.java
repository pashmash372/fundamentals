package com.scaler.scheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.scaler.scheduling.model.IncomingProcess;
import com.scaler.scheduling.model.ScheduledProcess;

public class FirstComeFirstServe {
    public List<ScheduledProcess> schedule(List<IncomingProcess> processes) {

        // get a sorted list of processes
        Queue<IncomingProcess> queue = prepareQueue(processes);
        List<ScheduledProcess> scheduledProcesses = new LinkedList<>();

        int time = 0;
        int index = 0;

        // check if there are any process in the queue

        while (!queue.isEmpty()) {
            IncomingProcess process = queue.poll();

            // Increment elapsed time by the burst time of the process

            time += process.getBurstTime();
            index += 1;

            process.setCompleteAt(time);

            // Add the process to the list of scheduled processes

            scheduledProcesses.add(new ScheduledProcess(index, process));
        }

        return scheduledProcesses;
    }

    private Queue<IncomingProcess> prepareQueue(List<IncomingProcess> processes) {

        Queue<IncomingProcess> queue = new LinkedList<>();
        List<IncomingProcess> sortedProcesses = new LinkedList<>(processes);

        // sort the processes by arrival time to simulate FCFS
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        for (IncomingProcess process : sortedProcesses) {
            queue.add(process);
        }
        return queue;

    }
}
