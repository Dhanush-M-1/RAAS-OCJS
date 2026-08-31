# import sys
# sys.stdin = open("test.in","r")
# sys.stdout = open("test.out","w")
n,k=map(int,input().split())
a=[]
for i in range(n):
	b=list(map(int,input().split()))
	for j in b[1::]:
		a.append(j)
		
if len(set(a))==k:
	print('YES')
else:
	print('NO')			