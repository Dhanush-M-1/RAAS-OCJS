from heapq import *
l=[]
n,k=map(int,input().split());
a,b,c=[],[],[]
for i in range(n):
	l.append(list(map(int,input().split())))

l.sort()

for i in range(n):
	la,lb=len(a)+len(c),len(b)+len(c)
	if((l[i][1]==1 or l[i][2]==1) and (la<k or lb<k)):

		if(l[i][1]==1 and l[i][2]==0 and la<k):
			heappush(a,-l[i][0])

		elif(l[i][1]==0 and l[i][2]==1 and lb<k):
			heappush(b,-l[i][0])

		elif((l[i][1]==1 and l[i][2]==1)):
			heappush(c,-l[i][0])

	elif((l[i][1]==1 and l[i][2]==1) and (la==k and lb==k)):
		ra,rb=0,0
		if(len(a)>0):
			ra=-a[0]
		if(len(b)>0):
			rb=-b[0]
		if((ra+rb)>l[i][0]):
			heappush(c,-l[i][0])

	if(len(a)+len(c)>k):
		heappop(a)

	if(len(b)+len(c)>k):
		heappop(b)

if(len(a)+len(c)<k or len(b)+len(c)<k):
	print(-1)

else:
	print(-(sum(a)+sum(b)+sum(c)))


