def fun(arr,N):
	l=[1,2,N]
	#print("sum of 1 and 2 elem: {}".format(arr[0]+arr[1]))
	#print("value of N-1: {}".format(arr[N-1]))
	if(arr[0]+arr[1]>arr[N-1]):
		l1=[-1]
		return l1
	else:
		return l
		
out=[]
test=int(input())
for x in range(test):
	N=int(input())
	arr=list(map(int,input().split()))
	out.append(fun(arr,N))
for x in range(len(out)):
	for k in range(len(out[x])):
		#print("len of column: {}".format(len(out[x])))
		print(out[x][k],end=" ")
	if x<len(out)-1:
		print()

		