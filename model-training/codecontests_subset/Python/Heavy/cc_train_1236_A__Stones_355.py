i = int(input())

for j in range(i):
    stones = 0
    a, b, c = [int(k) for k in input().split()]
    while (a>=1 and b>=2) or (b>=1 and c>=2):
        if c>=2:
            if b>=1 and c>=2:
                b -= 1
                c -= 2
                stones +=3
            elif a>=1 and b>=2:
                a -= 1
                b -= 2
                stones += 3
        else:
            if a>=1 and b>=2:
                a -= 1
                b -= 2
                stones += 3
            elif b>=1 and c>=2:
                b -= 1
                c -= 2
                stones += 3
    print(stones)
	  				  					     			  	   			