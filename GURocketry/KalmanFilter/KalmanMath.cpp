#include <Matrix.h>;


class KalmanMath {
	static const Matrix Q_Q = new Matrix(4, 4);
	static const Matrix Q = new Matrix(3, 3);
	static const long R_ACC; // Noise covariance for acceleration
	static const long R_ALT; // Noise covariance for altimeter


};