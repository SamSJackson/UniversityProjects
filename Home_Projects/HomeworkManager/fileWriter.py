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
		self._file = open(f"Databases/{filename}", "x+")
		return print(f"Created and opened {self._filename}")

	def openFile(self, filePath : Path) -> None:
		self._file = open(filePath, "a+")
		return print(f"Opened {self._filename}")

	def closeFile(self) -> None:
		print(f"{self._filename} closed")
		self._file.close()