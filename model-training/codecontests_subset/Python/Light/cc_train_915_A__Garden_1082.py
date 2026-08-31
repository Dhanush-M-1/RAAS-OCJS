a , b = list(map(int,input().split()))
l = list(map(int,input().split()))
l.sort()
for i in range(len(l)-1,-1,-1):
	if b%l[i]==0:
		print(b//l[i])
		break	
	