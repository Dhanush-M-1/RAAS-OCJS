# import sys
# sys.stdin=open("input.in","r")
n,m=map(int,input().split())
a=set()
for i in range(n):
	t=list(map(int,input().split()))
	for p in range(1,t[0]+1):
		a.add(t[p])

if len(a)!=m:
	print("NO")
else:
	print("YES")