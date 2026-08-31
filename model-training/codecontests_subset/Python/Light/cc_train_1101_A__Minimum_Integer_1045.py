queries = int(input())
solutions = []

for query in range(queries):
    integersInput = input().split(" ")
    
    lowerLimit = int(integersInput[0])
    upperLimit = int(integersInput[1])
    divisor = int(integersInput[2])

    foundInteger = divisor
    if foundInteger >= lowerLimit and foundInteger <= upperLimit:
        if upperLimit % divisor == 0:
            foundInteger = upperLimit + divisor
        else:
            foundInteger = upperLimit + divisor - (upperLimit % divisor)

    solutions.append(foundInteger)

for solution in solutions:
    print(solution)

				   			    	      	   	