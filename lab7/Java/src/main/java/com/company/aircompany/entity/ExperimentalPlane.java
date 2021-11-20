package com.company.aircompany.entity;

import com.company.aircompany.entity.classification.ClassificationLevel;
import com.company.aircompany.entity.classification.ExperimentalType;

public class ExperimentalPlane extends AbstractPlane {

    private ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    public void setType(ExperimentalType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ExperimentalPlane that = (ExperimentalPlane) o;

        if (type != that.type) return false;
        return classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (classificationLevel != null ? classificationLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExperimentalPlane{");
        sb.append(super.toString());
        sb.append("type=").append(type);
        sb.append(", classificationLevel=").append(classificationLevel);
        sb.append('}');
        return sb.toString();
    }
}
