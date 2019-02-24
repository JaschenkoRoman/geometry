package com.epam.geometry.observer;

import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class ConeObservable extends Cone implements Observable<ConeObservable> {
    private final Integer id;
    private List<Observer<ConeObservable>>  observers = new ArrayList<>();

    public ConeObservable(Integer id, Point centre, double height, double radius) {
        super(centre, height, radius);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Point getCentre() {
        return super.getCentre();
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setCentre(Point centre) {
        notifyObservers();
        super.setCentre(centre);
    }

    @Override
    public void setHeight(double height) {
        notifyObservers();
        super.setHeight(height);
    }

    @Override
    public void setRadius(double radius) {
        notifyObservers();
        super.setRadius(radius);
    }

    public void addObserver(Observer<ConeObservable> observer) {
        observer.update(this);
        observers.add(observer);
    }

    private void notifyObservers(){
        observers.forEach(observer -> observer.update(this));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + getCentre().hashCode();
        result = 31 * result + (int)Double.doubleToLongBits(getHeight());
        result = 31* result + (int)Double.doubleToLongBits(getRadius());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(obj.getClass() != this.getClass()) {
            return false;
        }
        ConeObservable coneObservable = (ConeObservable) obj;
        return id.equals(coneObservable.getId())&&
                getCentre().equals(coneObservable.getCentre()) &&
                Double.compare(getHeight(), coneObservable.getHeight()) == 0 &&
                Double.compare(getRadius(), coneObservable.getRadius()) == 0;
    }

    @Override
    public String toString() {
        return "ConeObservable: " + "id = " + id +
                " ,centre = " + getCentre().toString() +
                ", height = " + getHeight() +
                ", radius = " + getRadius();
    }
}
