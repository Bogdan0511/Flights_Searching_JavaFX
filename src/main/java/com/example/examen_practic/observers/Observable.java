package com.example.examen_practic.observers;

public interface Observable {
    void addObserver(Observer e);

    void removeObserver(Observer e);

    void notifyObservers();
}
