#pragma once

#ifndef KALMANMATH_H__
#define KALMANMATH_H__

#include "StateAndCovariance.h"
#include "Matrix.h"

class KalmanMath  {
public:
	static clock_t time_called;
	static Matrix calculateF(clock_t);
	static StateAndCovariance& correction(StateAndCovariance&, Matrix&, Matrix&, Matrix&);
	static StateAndCovariance& prediction(StateAndCovariance&, Matrix&);
	void kalmanLoop(Matrix&, StateAndCovariance&, Matrix&, Matrix&);
};

#endif