input1 = input().split()

n = int(input1[0])
k = int(input1[1])

vetor = sorted([int(c) for c in input().split()])

i = n - 1

while (i >= 0):
    seg = vetor[i]

    if (k % seg == 0):
        print(k // seg)
        break

    i -= 1
 					    	   		 	  		    	   	