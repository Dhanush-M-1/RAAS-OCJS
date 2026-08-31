n=int(input())
xh_pair=[]
for i in range(n):
	x,h=map(int,input().split())
	xh_pair.append((x,h))

nCount=1
pre=xh_pair[0][0]
for index in range(1,n-1):
	i=xh_pair[index]
	j=xh_pair[index+1]
	if i[0]-pre>i[1]:
		nCount+=1
		pre=i[0]
		continue
	if j[0]-i[0]>i[1]:
		nCount+=1
		pre=i[0]+i[1]
		continue
	pre=i[0]
if n==1:
	print(1)
else:
	print(nCount+1)
	