
from sys import stdin,stdout,setrecursionlimit
stdin.readline
def mp(): return list(map(int, stdin.readline().strip().split()))
def it():return int(stdin.readline().strip())
from collections import defaultdict as dd,Counter as C,deque
from math import ceil,gcd,sqrt,factorial,log2,floor	
from bisect import bisect_right as br,bisect_left as bl
import heapq


for _ in range(it()):
	input()
	k,n,m = mp()
	a,b = mp(),mp()
	a,b = deque(a),deque(b)
	v=[]
	flag = 0
	while a and b:
		if a[0] == 0:
			a.popleft()
			v.append(0)
			k += 1
		elif b[0] == 0:
			b.popleft()
			v.append(0)
			k += 1
		elif a[0]<b[0]:
			if k<a[0]:
				flag = 1
				print(-1)
				break
			else:
				v.append(a[0])
				a.popleft()
		else:
			if k<b[0]:
				flag = 1
				print(-1)
				break
			else:
				v.append(b[0])
				b.popleft()
	if flag:
		pass
	else:
		while a:
			if a[0] == 0:
				a.popleft()
				v.append(0)
				k += 1
			else:
				if k<a[0]:
					flag = 1
					print(-1)
					break
				else:
					v.append(a[0])
					a.popleft()
		while b:
			if b[0] == 0:
				b.popleft()
				v.append(0)
				k += 1
			else:
				if k<b[0]:
					flag = 1
					print(-1)
					break
				else:
					v.append(b[0])
					b.popleft()
		if not flag:
			print(*v)

