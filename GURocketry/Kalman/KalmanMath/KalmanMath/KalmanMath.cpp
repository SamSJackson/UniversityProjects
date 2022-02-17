#include "Matrix.h"
#include "KalmanMath.h"
#include <ctime>
#include <cmath>
#include <Windows.h>

using std::istream; using std::ostream; using std::clock; using std::vector;
using std::pow; 

Matrix KalmanMath::calculateF() {
	clock_t time_difference = clock() - KalmanMath::time_called;
	double timeInSeconds = time_difference / (double)CLOCKS_PER_SEC;
	double halfDtSquared = (1.0 / 2.0) * (pow(timeInSeconds, 2.0));
	vector<vector<double>> matrixList = { {1, timeInSeconds, halfDtSquared}, {0, 1, timeInSeconds}, {0,0,1} };
	Matrix* FMatrix = new Matrix(matrixList, 3, 3);
	Sleep(3000);
	KalmanMath::time_called = clock();
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
	std::cout << "Finished correcting" << '\n';
	return SC;
}

StateAndCovariance& KalmanMath::prediction(StateAndCovariance& SC) {
	Matrix F = KalmanMath::calculateF();
	Matrix FTranspose = F.transpose();
	SC.state = F * SC.state;
	SC.covariance = (F * SC.covariance) * FTranspose;
	std::cout << "Finished predicting" << '\n';
	return SC;
}

void KalmanMath::kalmanLoop(Matrix& H, StateAndCovariance& SC, Matrix& sensorData, Matrix& R) {
	if (H(0, 0) == 1 && H(1, 2) == 1) {
		KalmanMath::correction(SC, sensorData, H, R);
	}
	else if (H(0, 0) == 1 || H(1, 2) == 1) {
		KalmanMath::correction(SC, sensorData, H, R);
	}
	else {
		KalmanMath::prediction(SC);
	}
	KalmanMath::time_called = clock();
}

int main() {
	KalmanMath km;
	StateAndCovariance SC;
	vector<vector<double>> HList = { {1,0,0}, {0,0,1} };
	Matrix* sensorData = new Matrix();
	Matrix* H = new Matrix(HList, 2, 3);
	Matrix* R = new Matrix(2, 2);
	SC.state = Matrix(3, 1);
	SC.covariance = Matrix(3, 3);
	std::cout << km.time_called << '\n';
	km.calculateF();
	std::cout << km.time_called << '\n';
	return 0;
}

