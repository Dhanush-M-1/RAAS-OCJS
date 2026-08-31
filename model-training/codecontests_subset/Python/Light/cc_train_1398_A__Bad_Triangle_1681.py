t=int(input())
for _ in range(t):
	n=int(input())
	k=0
	l=list(map(int,input().split(" ")))
	s=l[0]+l[1]
	for a in range(2,n):
		if s<=l[a]:
		   print(""+str(1)+" "+str(2)+" "+str(a+1))
		   k=-1
		   break
	if k!=-1:
		print("-1")


