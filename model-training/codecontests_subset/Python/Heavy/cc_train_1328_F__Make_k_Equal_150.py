import sys

[n,k]=[int(i) for i in sys.stdin.readline().split()]

a=[int(j) for j in sys.stdin.readline().split()]

arr=[]

a.sort()

prev=-2
for i in range(n):
	if(prev!=a[i]):
		arr.append([a[i],1])
	else:
		arr[-1][1]+=1
	prev=a[i]

done=0
for j in range(len(arr)):
	if(arr[j][1]>=k):
		done=1
		break

if(done==1):
	print(0)
else:

	count_arr=[]

	for w in range(200001):
		count_arr.append([0,0])

	# 0 is steps
	# 1 is count

	ans=sys.maxsize

	for h in range(n):
		count_arr[a[h]][1]+=1

	for g in range(n):
		tmp=a[g]

		tmp//=2
		step=1

		while(tmp!=0):	
			count_arr[tmp][0]+=step
			count_arr[tmp][1]+=1

			if(count_arr[tmp][1]>=k):
				ans=min(ans,count_arr[tmp][0])

			step+=1
			tmp//=2

		count_arr[0][0]+=step
		count_arr[0][1]+=1

		if(count_arr[0][1]>=k):
			ans=min(ans,count_arr[0][0])

	print(ans)