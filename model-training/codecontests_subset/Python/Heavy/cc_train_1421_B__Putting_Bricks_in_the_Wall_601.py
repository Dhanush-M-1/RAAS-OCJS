def i(): return int(input())
def mp() : return map(str,input().split())
def si() : return input()
from collections import defaultdict as dd, deque as dq,Counter as c
from math import factorial as f ,ceil,gcd,sqrt
for _ in range(i()):
	a = i()
	b =[]
	for _ in range(a):
		b.append(list(input()))
	t = b[0][1]
	r = b[1][0]
	y = b[a-1][a-2]
	u = b[a-2][a-1]
	ans =[]
	if t==r:
		if y==t:
			ans.append([a,a-1])
		if u==t:
			ans.append([a-1,a])
		print(len(ans))
		for k in range(len(ans)):
			print(*ans[k])
	elif y==u:
		if t==y:
			ans.append([1,2])
		if r==y:
			ans.append([2,1])
		print(len(ans))
		for k in range(len(ans)):
			print(*ans[k])
	else:
		ans.append([2,1])
		if y==t:
			ans.append([a,a-1])
		if u==t:
			ans.append([a-1,a])
		print(len(ans))
		for k in range(len(ans)):
			print(*ans[k])