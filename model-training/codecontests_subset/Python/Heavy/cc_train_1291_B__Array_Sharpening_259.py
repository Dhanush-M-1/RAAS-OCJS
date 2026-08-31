# from debug import debug
import sys
		
input = sys.stdin.readline
# t, n, lis
t_ = int(input())
while t_:
	t_-=1
	n = int(input())
	lis = list(map(int, input().split()))
	l = [False]*n; l[0] = True
	h = [False]*n; h[-1] = True
	for i in range(1, n): 
		if (i-lis[i]<=0 and not (lis[i] == 0 and i!=0)): l[i] = True
		else: l[i] = False; break
	for i in range(n-2, -1, -1): 
		if (lis[i]+i>=n-1 and not (lis[i] == 0 and i!= n-1)): h[i] = True
		else: h[i] = False; break
	ans = False
	for i in range(n): ans = ans or (l[i] and h[i])
	if ans: print("Yes")
	else: print("No")
	