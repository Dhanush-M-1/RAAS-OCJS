import sys
from copy import deepcopy
for t in range(int(input())):
    n = int(input())
    last_p = 0
    last_c = 0
    l = []
    for i in range(n):
    	# print()
    	p, c = [int(j) for j in input().split()]
    	l.append((p, c))
    for i in range(n):
    	p,c = l[i]
    	a = p-last_p
    	b = c - last_c
    	# print(a, b)
    	if a>=b and b>=0:
    		pass
    	else:
    		sys.stdout.write("NO")
    		sys.stdout.write("\n")
    		break
    	last_c = c
    	last_p = p
    else:
    	sys.stdout.write("YES")
    	sys.stdout.write("\n")