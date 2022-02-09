import datetime

class Homework:

	def __init__(self, course : str, due : datetime, task : str):
		self._course = course
		self._due = due
		self._task = task
		self._completed = False

	@property
	def getCourse(self):
		return self._course

	@property
	def dueDate(self):
		return self._dueDate
	
	@property
	def getTask(self):
		return self._task

	def changeTask(self, task : str):
		self._task = task

	def changeCourse(self, course : str):
		self._course = course

	def completeTask(self, isCompleted : bool):
		self._completed = isCompleted
