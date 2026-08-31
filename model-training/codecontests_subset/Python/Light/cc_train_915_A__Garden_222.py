n,k = map(int,input().split())
bucky = list(map(int,input().split()))
bucky = sorted(bucky,reverse=True)

for i in bucky:
	if k%i==0:
		print(k//i)
		break