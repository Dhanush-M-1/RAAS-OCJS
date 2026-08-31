def mi():
	return map(int, input().split())
import math
for _ in range(int(input())):
	n = int(input())
	a = list(mi())
	s = 0
	ss=0
	for i in a:
		if i!=-1:
			s+=i
			ss+=1
	if ss==0:
		print (0,1)
		continue
	s,ss=0,0
	cc = []
	for i in range(n):
		if a[i]==-1:
			if i-1>=0 and a[i-1]!=-1:
				cc+=[a[i-1]]
				ss+=1
			if i+1<n and a[i+1]!=-1:
				cc+=[a[i+1]]
				ss+=1
	ans = (min(cc)+max(cc))//2
	for i in range(n):
		if a[i]==-1:
			a[i] =ans
	m=0
	for i in range(1,n):
		m = max(m, abs(a[i]-a[i-1]))
	print (m, ans)
				