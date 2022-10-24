package com.scaler.scheduling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduledProcess {
    private int index;
    private IncomingProcess process;

    public int getId() {
        return process.getId();
    }
}
