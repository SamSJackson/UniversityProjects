class Kalman:

	Q_Q = Matrix(4,4)
	Q = Matrix(3,3)
	R_ACC = float
	R_ALT = float

	def __init__(self):
		self._predicted = Matrix(3,3)
		self._actual = Matrix(3,3)
		self._previous = Matrix(3,3)

	def prediction(self, state, covariance):
		F = calcF(time_since_last_call)
		State = F * State
		Covariance = ...


	def calcF(time_since_last_call):
		dt = time.now() - time_since_last_call
		return [1, dt, (dt^2)/2,
				0, 1, dt,
				0, 0, 1]


