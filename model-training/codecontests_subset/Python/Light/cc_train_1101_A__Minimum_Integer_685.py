def minimum_integer(l,r,d):
    if(d > r or d < l):
        return d
    else:
        d *= ((r//d)+1)
        return d

q = int(input())
for e in range(q):
    l, r, d = map(int, input().split())
    print(minimum_integer(l,r,d))
 		 	 		 				  	 	   	 	 			