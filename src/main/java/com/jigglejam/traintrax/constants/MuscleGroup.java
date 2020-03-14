package com.jigglejam.traintrax.constants;

public enum MuscleGroup {
    ABDOMINALS_LOWER("lower abdominals"),
    ABDOMINALS_UPPER("upper abdominals"),
    ADDUCTORS("adductors"),
    BICEPS("biceps"),
    CALVES("calves"),
    DELTOIDS("deltoids"),
    FOREARMS("forearms"),
    GLUTEALS("gluteals"),
    HAMSTRINGS("hamstrings"),
    LATISSIMUS_DORSI("latissimus dorsi"),
    OBLIQUES("obliques"),
    PECTORALS("pectorals"),
    QUADRICEPS("quadriceps"),
    TRAPEZIUS("trapezius"),
    TRICEPS("triceps");

    private String name;

    MuscleGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
