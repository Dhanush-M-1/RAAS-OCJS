

def FindTheCure(stingLenght, letters):
	twoGrams = []
	twoGramCount = []
	i = 0
	
	while i < stingLenght - 1:
		twoGram = letters[i] + letters[i+1]
		if twoGram not in twoGrams:
			twoGrams.append(twoGram)
			twoGramCount.append(1)
		else:
			x = 0
			while x < len(twoGrams):
				if twoGrams[x] == twoGram:
					twoGramCount[x] += 1
					break
				else: 
					x += 1	
				
		
		i += 1
		
	print(twoGrams[twoGramCount.index(max(twoGramCount))])
	
	
stringLenght = int(input())
letters = input()

FindTheCure(stringLenght, letters)

