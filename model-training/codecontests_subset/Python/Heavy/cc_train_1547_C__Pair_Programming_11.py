import sys
LI=lambda:list(map(int,sys.stdin.readline().split()))
MI=lambda:map(int,sys.stdin.readline().split())
SI=lambda:sys.stdin.readline().strip('\n')
II=lambda:int(sys.stdin.readline())
from collections import deque
for _ in range(II()):
	input()
	k, n, m=MI()
	a, b=deque(LI()), deque(LI())
	r=[]
	ok=1
	while a or b:
		# print(a, b)
		if a and a[0]==0:
			r.append(0)
			a.popleft()
			k+=1
		elif b and b[0]==0:
			r.append(0)
			b.popleft()
			k+=1
		else:
			if a and a[0]<=k:
				r.append(a[0])
				a.popleft()
			elif b and b[0]<=k:
				r.append(b[0])
				b.popleft()
			else:
				ok=0
				break
	if ok:print(*r)
	else:print(-1)