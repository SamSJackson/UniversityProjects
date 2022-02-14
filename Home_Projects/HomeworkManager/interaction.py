from task import Task

class Interaction:

	def user_action(self, userChoice : str, userContent : str):
		match userChoice:
			case "add":
				user_add(userContent)
			case "delete":
				user_delete(userContent)
			case "complete":
				user_complete(userContent)
			case "display":
				user_display()


	def user_display(self):
		...

	def user_add(self, userContent : str):
		...

	def user_delete(self, userContent : str)
		...

	def user_complete(self, userContent : str)
		...
