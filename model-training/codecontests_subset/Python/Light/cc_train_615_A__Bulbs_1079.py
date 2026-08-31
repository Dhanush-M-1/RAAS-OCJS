# import sys
# sys.stdin=open("input.in","r")
# sys.stdout=open("output.out","w")
n,m=map(int,input().split())
X=[]
while n:
	L=list(map(int,input().split()))
	for i in range(1,len(L)):
		X.append(L[i])
	n-=1
if(len(set(X))<m):
	print("NO")
else:
	print("YES")