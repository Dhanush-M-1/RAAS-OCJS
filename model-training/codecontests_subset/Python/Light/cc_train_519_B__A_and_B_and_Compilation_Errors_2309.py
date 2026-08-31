import sys
n = int(input())
A = {}
for d in input().split():
    i = int(d)
    if i in A:
        A[i] += 1
    else:
        A[i] = 1

for line in sys.stdin.readlines():
    B = {}
    for d in line.split():
        i = int(d)
        if i in B:
            B[i] += 1
        else:
            B[i] = 1
        A[i] -= 1
        if A[i] == 0:
            del A[i]
    print(sum(A.keys()), end=' ')
    A = B

  		 	     		 		  	 	 						 	