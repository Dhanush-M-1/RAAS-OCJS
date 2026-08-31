from collections import defaultdict
n,m = [int(i) for i in input().split()]

d = defaultdict(int)

for i in range(n):
    u = [int(i) for i in input().split()]
    for j in u[1:]:
        d[j] = 1

check = True
for i in range(1,m+1):
    if d[i] == 0:
        check = False
        break

if check:
    print('YES')
else:
    print('NO')

 					  			    			 		 				 	  	