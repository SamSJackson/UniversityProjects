#include <Matrix.h>;
#include <KalmanMath.h>;

Matrix& KalmanMath::calculateF(float current_time) {
	// Need to return matrix with change of time ^2
	float change_in_time = // get time - current_time
}

StateAndCovariance& KalmanMath::correction(StateAndCovariance SC, Matrix F, Matrix sensorData, Matrix H) {

}


int main() {
	StateAndCovariance SA = new StateAndCovariance();
}

