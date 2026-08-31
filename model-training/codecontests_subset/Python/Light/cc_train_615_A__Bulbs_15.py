n,m=map(int,input().split())
c=0
s=[]
for i in range(n):
	z,*a=list(map(int,input().split()))
	for j in a:
		if(j not in s):
			s.append(j)
if(len(s)==m):
	print("YES")
else:
	print("NO")
		

