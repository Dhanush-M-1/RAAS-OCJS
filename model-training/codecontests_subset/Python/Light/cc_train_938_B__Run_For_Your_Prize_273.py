n=int(input())
pos=input().split()
for i in range(0,len(pos)):
	pos[i]=int(pos[i])
minn=0
for i in pos:
	
	n=min((i-1),((10**6)-i))
	
	if(n>minn):
		minn=n
print(minn)

	
