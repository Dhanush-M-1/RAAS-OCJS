
from sys import stdin, stdout
 
T = int(stdin.readline())
ver = set()
 
#pdb.set_trace()
for _ in range(T):
	
	ver.clear()
	n, m = map(int, stdin.readline().split())
	n *= 3
	edge = []
 
	for __ in range(m):
	
		u, v = map(int, stdin.readline().split())
	
		if u not in ver and v not in ver:
			edge.append(__+1)
			ver.add(u)
			ver.add(v)
		
			if len(edge) == n//3:
				print("Matching")
				
				print(*edge[:n//3])
				for x in range(__ + 1,m):
					stdin.readline()
 
				break
 
	if len(edge) < n//3:
		asd = []
		for x in range(1,n+1):
			if x not in ver: asd.append(x)
			if len(asd) == n//3:
				print("IndSet")
				print(*asd[:n//3])
				break
 
		if len(asd) < n//3: stdout.write("Impossible\n")