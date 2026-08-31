# collaborated with no one

books, days = map(int, input().split())

weights = input().split()
weights = list(map(int, weights))

order = input().split()
order = list(map(int, order))

setOrder = list(dict.fromkeys(order))

booksAndWeights = dict()

for a in range(len(weights)):
    booksAndWeights[a + 1] = weights[a]

for x in range(len(setOrder)):
    weights[x] = setOrder[x]

finalCounter = 0

for b in order:
    index = 0
    while weights[index] != b:
        finalCounter = finalCounter + booksAndWeights[weights[index]]
        index += 1
    weights.insert(0, weights.pop(index))

print(finalCounter)
	     						  	 	  	 	  		   	