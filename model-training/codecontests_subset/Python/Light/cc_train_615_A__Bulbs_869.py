# import sys
# sys.stdin=open("input.in","r")
# sys.stdout=open("output.out","w")

n,m=map(int,input().split())
g=[]
for i in range(n):
	l=list(map(int,input().split()))
	for j in range(1,l[0]+1):
		g.append(l[j]) 
r=set(g)
if(len(r)==m):
	print("YES")
else:
	print("NO")			
	