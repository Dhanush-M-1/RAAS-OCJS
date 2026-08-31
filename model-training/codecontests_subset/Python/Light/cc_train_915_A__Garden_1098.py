
n,m=map(int,input().split())
l=sorted(list(map(int,input().split())),reverse=True)
for i in l:
	if(m%i==0):
		print(m//i)
		break