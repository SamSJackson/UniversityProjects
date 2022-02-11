from fileWriter import FileWriter

if __name__ == '__main__':
	isCorrect = "no"
	while (isCorrect != "yes"):
		file_input = input("File name: ")
		fw = FileWriter(file_input)
		isCorrect = (input("Is this correct? ").strip())
		print(isCorrect)

	choice = input("")

	fw.closeFile()
