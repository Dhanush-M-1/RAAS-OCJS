n,k=map(int,input().split())
alice=[]
bob=[]
both =[]
for i in range(n):
	t,a,b = map(int,input().split())
	if (a==1 and b==1):
		both.append(t)
	elif (a==1):
		alice.append(t)
	elif (b==1):
		bob.append(t)
alice.sort()
bob.sort()
l = min(len(alice),len(bob))
for i in range(l):
	both.append(alice[i]+bob[i])
if (len(both)< k):
	print(-1)
else:
	both.sort()
	sumi=0
	for i in range(k):
		sumi=sumi+both[i]
	print(sumi)

