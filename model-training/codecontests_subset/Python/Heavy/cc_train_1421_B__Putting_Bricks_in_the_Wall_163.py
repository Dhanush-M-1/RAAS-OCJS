import sys
input=sys.stdin.readline
for _ in range(int(input())):
	n=int(input())
	# a,b=map(int,input().split())
# 	s=input().strip()
	# a=list(map(int,input().split()))
	g=[]
	ans,ans1=[],[]
	for i in range(n):g.append(input())
	s1,s2=g[0][1],g[1][0]
	e1,e2=g[n-1][n-2],g[n-2][n-1]
	if s1==s2=='0':
		if e1=='0':
			ans.append((n-1,n-2))
		if e2=='0':
			ans.append((n-2,n-1))
	elif s1==s2=='1':
		if e1=='1':
			ans.append((n-1,n-2))
		if e2=='1':
			ans.append((n-2,n-1))
	elif e1==e2=='0':
		if s1=='0':
			ans.append((0,1))
		if s2=='0':
			ans.append((1,0))
	elif e1==e2=='1':
		if s1=='1':
			ans.append((0,1))
		if s2=='1':
			ans.append((1,0))
	else:
		if s1=='0':
			ans.append((1,0))
			if e1=='0':
				ans.append((n-1,n-2))
			if e2=='0':
				ans.append((n-2,n-1))
		else:
			ans.append((1,0))
			if e1=='1':
				ans.append((n-1,n-2))
			if e2=='1':
				ans.append((n-2,n-1))
	print(len(ans))
	for i,j in ans:
		print(i+1,j+1)