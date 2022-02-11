from pathlib import Path

class FileWriter:

	def __init__(self, filename):
		self._filename = filename if '.txt' in filename else filename+".txt" 
		self._path = Path(f"Databases/{self._filename}")
		if (self._path.is_file()):
			self.openFile(self._path)
		else:
			self.createAndOpenFile(self._filename)

	def createAndOpenFile(self, filename) -> None:
		self._f = open(f"Databases/{filename}", "x+")
		print(f"Created and opened {self._filename}")
		return 

	def openFile(self, filePath : Path) -> None:
		self._f = open(filePath, "a+")
		return print(f"Opened {self._filename}")

	def closeFile(self) -> None:
		print("File closed")
		self._f.close()