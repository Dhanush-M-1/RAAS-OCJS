from collections import defaultdict
n=int(input())
a=[int(x) for x in input().split()]
b=sorted(a,reverse=True)
for _ in range(int(input())):
	k,pos=map(int,input().split())
	d=defaultdict(int)
	for i in range(k):
		d[b[i]]+=1
	count=0
	num=-1
	for x in a:
		if d[x]:
			d[x]-=1
			count+=1
		if count==pos:
			num=x
			break
	print(num)