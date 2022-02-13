#include "Matrix.h"
#include "KalmanMath.h"
#include <ctime>
#include <cmath>
#include <Windows.h>

using std::istream; using std::ostream; using std::clock; using std::vector;
using std::pow; 

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
	return SC;
}

StateAndCovariance& KalmanMath::prediction(StateAndCovariance& SC, Matrix& F) {
	Matrix FTranspose = F.transpose();
	SC.state = F * SC.state;
	SC.covariance = (F * SC.covariance) * FTranspose;
	return SC;
}

void KalmanMath::kalmanLoop(Matrix& measurements) {

}

int main() {
	KalmanMath km;
	StateAndCovariance SC;
	SC.state = Matrix(3, 1);
	SC.covariance = Matrix(3, 3);
	clock_t timestamp = clock();
	Sleep(1000);
	Matrix FMatrix = km.calculateF(timestamp);
	Matrix* sensorData = new Matrix(2, 1);
	Matrix* H = new Matrix(2, 3);
	Matrix* R = new Matrix(2, 2);
	SC = km.prediction(SC, FMatrix);
	SC = km.correction(SC, *sensorData, *H, *R);

	std::cout << SC.state << '\n';
	std::cout << SC.covariance << '\n';
	return 0;
}

