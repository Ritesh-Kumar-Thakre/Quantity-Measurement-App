package com.apps.quantitymeasurement;

public interface Unit {

	double toBase(double value);

	double fromBase(double baseValue);

	double getConversionFactor();
}