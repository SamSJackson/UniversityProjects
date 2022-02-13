#pragma once

#ifndef KALMANMATH_H__
#define KALMANMATH_H__

#include "StateAndCovariance.h"
#include "Matrix.h"

class KalmanMath  {
public:
	static clock_t time_called;
	Matrix calculateF(clock_t);
	StateAndCovariance& correction(StateAndCovariance&, Matrix&, Matrix&, Matrix&);
	StateAndCovariance& prediction(StateAndCovariance&, Matrix&);
	void kalmanLoop(Matrix&);
};

#endif