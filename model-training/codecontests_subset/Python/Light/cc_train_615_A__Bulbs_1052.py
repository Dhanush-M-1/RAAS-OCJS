# import sys 
# sys.stdin=open("input.in",'r')
# sys.stdout=open("outp.out",'w')
n,m=map(int,input().split())
l=[]
for i in range(n):
	x=list(map(int,input().split()))
	x.remove(x[0])
	for j in x:
		l.append(j)
s=set(l)
if m==len(s):
	print("YES")
else:
	print("NO")		