import sys
input = sys.stdin.readline
I = lambda : list(map(int,input().split()))

t,=I()
for _ in range(t):
	n,=I()
	l=I()
	an=-1
	i=0
	if n>=3 and l[i]+l[i+1]<=l[n-1]:
		print(1,2,n)
	else:
		print(-1)