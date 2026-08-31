#!/user/bin/python

firstLine = input()
secondLine = input()





if __name__ == '__main__':
	_firstLine = firstLine.split(' ')
	_secondLine = secondLine.split(' ')
	minHours = 10e10
	gardenLenght = int(_firstLine[1])
	for bucket in _secondLine:
		
		if gardenLenght%(int(bucket)) == 0:
			hours = gardenLenght//(int(bucket))
			if minHours > hours:
				minHours = hours
	print(minHours)
	