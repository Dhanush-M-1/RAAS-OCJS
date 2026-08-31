from bisect import bisect_left
for i in range(int(input())):
	n, m = map(int,input().split());a = list(map(int,input().split()));p = [0]*(n+1);M = [0]*(n+1)
	for i in range(n):p[i+1] = p[i] + a[i];M[i+1] = max(M[i], p[i+1])
	s = p[-1];ans = []
	for x in map(int,input().split()):
		r = 0
		if s > 0:t = max((x-M[-1]+s-1)//s,0);r += t*n;x -= t*s
		ans.append('-1' if x > M[-1] else str(r + bisect_left(M,x) - 1))
	print(' '.join(ans))