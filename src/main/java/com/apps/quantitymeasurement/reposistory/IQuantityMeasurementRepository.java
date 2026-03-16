package com.apps.quantitymeasurement.reposistory;

import java.util.List;

import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {
	void save(QuantityMeasurementEntity enity);

	List<QuantityMeasurementEntity> getAllMeasurement();
}
