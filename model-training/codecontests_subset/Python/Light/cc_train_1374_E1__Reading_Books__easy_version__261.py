
def main():
    n, k = [int(x) for x in input().split()]
    alice, bob = 0, 0
    both, j_a, j_b = [], [], []
    for i in range(n):
        b = [int(x) for x in input().split()]
        if(b[1] + b[2] == 2):
            both.append(b)
        elif (b[1] == 1):
            j_a.append(b)
        elif(b[2] == 1):
            j_b.append(b)

    j_a.sort()
    j_b.sort()
    for i in range(min(len(j_a), len(j_b))):
        b = [j_a[i][0] + j_b[i][0], 1, 1]
        both.append(b)
    if(len(both) < k):
        return -1
    both.sort()
    return sum([b[0] for b in both[:k]])

print(main())
	   	 	    			 	   	  	  	   	