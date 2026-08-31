# import sys
# sys.stdin=open("input.in","r")
# sys.stdout=open("output.out","w")


a,p=map(int,input().split())
d,k=[],0
for x in range(a):
	b=[]
	b.append(list(map(int,input().split())))
	for j in range(1,b[0][0]+1):
		d.append(b[0][j])
m=list(set(d))
for x in range(1,p+1):	
	if x in m:
		k=1
	else:
		k=0
		print('NO')
		break
if k==1:
	print('YES')