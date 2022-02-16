#include "Matrix.h"
#include "KalmanMath.h"
#include <ctime>
#include <cmath>
#include <Windows.h>

using std::istream; using std::ostream; using std::clock; using std::vector;
using std::pow; 

clock_t KalmanMath::time_called = clock();

Matrix KalmanMath::calculateF(clock_t timestamp) {
	clock_t time_difference = clock() - timestamp;
	double timeInSeconds = time_difference / (double)CLOCKS_PER_SEC;
	double halfDtSquared = (1.0 / 2.0) * (pow(timeInSeconds, 2.0));
	vector<vector<double>> matrixList = { {1, timeInSeconds, halfDtSquared}, {0, 1, timeInSeconds}, {0,0,1} };
	Matrix* FMatrix = new Matrix(matrixList, 3, 3);
	return *FMatrix;
}

StateAndCovariance& KalmanMath::correction(StateAndCovariance& SC, Matrix& sensorData, Matrix& H, Matrix& R) {
	Matrix I_3 = Matrix::createIdentity(3);
	Matrix HTranspose = H.transpose();
	Matrix invS = ((H * SC.covariance) * HTranspose + R).inverse();
	Matrix kalmanGain = SC.covariance * HTranspose * (invS);
	SC.state = SC.state + kalmanGain * (sensorData - H * SC.state);
	Matrix post = (I_3 - kalmanGain * H);
	Matrix postTranspose = (I_3 - kalmanGain * H).transpose();
	Matrix kalmanTranspose = kalmanGain.transpose();
	SC.covariance = post * SC.covariance * postTranspose + ((kalmanGain * R) * kalmanTranspose);
	std::cout << "FINISHING THIS CORRECTION" << '\n';
	return SC;
}

StateAndCovariance& KalmanMath::prediction(StateAndCovariance& SC, Matrix& F) {
	Matrix FTranspose = F.transpose();
	SC.state = F * SC.state;
	SC.covariance = (F * SC.covariance) * FTranspose;
	return SC;
}

void KalmanMath::kalmanLoop(Matrix& H, StateAndCovariance& SC, Matrix& sensorData, Matrix& R) {
	std::cout << "MADE IT HERE" << '\n';
	if (H(0, 0) == 1 && H(1, 2) == 1) {
		std::cout << "Correction first step done here" << '\n';
		KalmanMath::correction(SC, sensorData, H, R);
		std::cout << "Correction finished H step done here" << '\n';
	}
	else if (H(0, 0) == 1 || H(1, 2) == 1) {
		std::cout << "Correction small H step done here" << '\n';
		KalmanMath::correction(SC, sensorData, H, R);
		std::cout << "Correction finished small H step done here" << '\n';
	}
	else {
		Matrix FMatrix = KalmanMath::calculateF(KalmanMath::time_called);
		std::cout << "Pre-prediction step" << '\n';
		KalmanMath::prediction(SC, FMatrix);
		KalmanMath::time_called = clock();
		std::cout << "Prediction step" << '\n';
	}
	std::cout << "THIS IS GOOD" << '\n';
}

int main() {
	KalmanMath km;
	StateAndCovariance SC;
	vector<vector<double>> HList = { {0,0,0}, {0,0,0} };
	Matrix* sensorData = new Matrix();
	Matrix* H = new Matrix(HList, 2, 3);
	Matrix* R = new Matrix(2, 2);
	SC.state = Matrix(3, 1);
	SC.covariance = Matrix(3, 3);
	std::cout << KalmanMath::time_called << '\n';
	km.kalmanLoop(*H, SC, *sensorData, *R);
	std::cout << KalmanMath::time_called << '\n';

	return 0;
}

