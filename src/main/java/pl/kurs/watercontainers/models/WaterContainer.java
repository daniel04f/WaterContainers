package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidCapacityException;
import pl.kurs.watercontainers.exceptions.InvalidLevelException;

import java.io.Serializable;
import java.util.Objects;

public class WaterContainer implements Serializable {


    private String name;
    private double maxCapacity;
    private double waterLevel;

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public String getName() {
        return name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(that.maxCapacity, maxCapacity) == 0 && Double.compare(that.waterLevel, waterLevel) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, waterLevel);
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }

    public static WaterContainer create(String name, double maxCapacity, double waterLevel) throws InvalidCapacityException {
        if (maxCapacity <= 0) {
            throw new InvalidCapacityException("Max capacity must by more than 0");
        }
        if (waterLevel > 0 && waterLevel < maxCapacity) {
            throw new InvalidLevelException("Invalid water level value");
        }
        return new WaterContainer(name, maxCapacity, waterLevel);
    }



}
