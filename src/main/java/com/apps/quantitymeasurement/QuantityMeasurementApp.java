package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

	public static class Feet {
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (obj == null || this.getClass() != obj.getClass()) {
				return false;
			}

			Feet other = (Feet) obj;
			return Double.compare(this.value, other.value) == 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first feet: ");
		double f1 = sc.nextDouble();
		System.out.print("Enter second feet: ");
		double f2 = sc.nextDouble();
		Feet feet1 = new Feet(f1);
		Feet feet2 = new Feet(f2);

		System.out.println("Are they equal? " + feet1.equals(feet2));
		sc.close();
	}
}