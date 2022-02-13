
#ifndef __KALMANMATH_H__
#define __KALMANMATH_H__

#include <Matrix.h>

typedef struct StateAndCovariance {
	float state;
	float covariance;
} StateAndCovariance;


class KalmanMath {
	
public:

	Matrix& calculateF(time_difference);
	StateAndCovariance& correction(StateAndCovariance previous, Matrix F, Matrix measurements, Matrix H);
	StateAndCovariance& prediction(StateAndCovariance previous, Matrix F);
	void kalmanLoop(Matrix sensorData);
	
};