package com.trainer;

import java.util.Comparator;

class SortByTrainingId implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getId() - o2.getId();
    }
}

class SortByCourseName implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getCourseName().compareTo(o2.getCourseName());
    }
}

class SortByClientName implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getClientName().compareTo(o2.getClientName());
    }
}

class SortByCost implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
         return (int)(o1.getCost() - o2.getCost());
    }
}

class SortByStatus implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getStatus().getState().compareTo(o2.getStatus().getState());
    }
}

class SortByPaymentState implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getPayState().getState().compareTo(o2.getPayState().getState());
    }
}

class SortByDate implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}

class SortByDuration implements Comparator<Training> {
    @Override
    public int compare(Training o1, Training o2) {
        return o1.getDuration() - o2.getDuration();
    }
}