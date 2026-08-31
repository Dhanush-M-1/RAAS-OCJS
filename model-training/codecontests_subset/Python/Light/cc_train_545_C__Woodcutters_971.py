n=int(input())
list0=[]
for i in range(n):
	xi,hi=map(int,input().split())
	list0.append((xi,hi))
list0.sort()
if len(list0)==1:
	print(1)
elif len(list0)==2:
	print(2)
else:
	k=list0[0][0]
	num=2
	for i in range(1,n-1):
		if list0[i][0]-list0[i][1]>k:
			num+=1
			k=list0[i][0]
		elif list0[i][0]+list0[i][1]<list0[i+1][0]:
			num+=1
			k=list0[i][0]+list0[i][1]
		else:
			k=list0[i][0]
	print(num)



