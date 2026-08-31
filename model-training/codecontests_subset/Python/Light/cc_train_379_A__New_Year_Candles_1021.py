n,t=map(int,input().split())
day=1
while n>0:
	if day%t==0:
		n+=1
	day+=1
	n-=1
print(day-1)
