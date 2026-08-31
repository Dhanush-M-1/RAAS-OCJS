import math

t = int(input())

for i in range(t):
    kMax = -1000000000
    kMin = 1000000000
    n = int(input())
    array = input()
    array = array.split(' ')
    array = [int(x) for x in array]


    for i in range(len(array)):
        if i > 0 and array[i] == -1 and array[i-1] != -1:
            kMax = max([kMax,array[i-1]])
            kMin = min([kMin,array[i-1]])
        if i < n-1 and array[i] == -1 and array[i+1] != -1:
            kMax = max([kMax,array[i+1]])
            kMin = min([kMin,array[i+1]])

    k = (kMax+kMin)//2
    for i in range(len(array)):
        if array[i] == -1:
            array[i] = k
    maxDifference = 0
    for i in range(len(array)-1):
        maxDifference = max([maxDifference,abs(array[i]-array[i+1])])
    print(maxDifference,k)



	    	 						 	 			    	 	 		 	