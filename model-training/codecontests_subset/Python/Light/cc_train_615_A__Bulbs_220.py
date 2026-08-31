# import sys
# sys.stdin=open('input.in','r')
# sys.stdout=open('output.out','w')
n,m=map(int,input().strip().split()[:2])
bulb=list(0 for x in range(m+1))
for x in range(n):
	k=list(map(int,input().strip().split()[:m+1]))
	for y in k[1:]:
		bulb[y]=1
if all(bulb[1:])==True:
	print('YES')
else:
	print('NO')
