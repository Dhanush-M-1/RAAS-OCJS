def I(): return(list(map(int,input().split())))
def sieve(n):
	a=[1]*n
	for i in range(2,n):
	    if a[i]:
	        for j in range(i*i,n,i):
	            a[j]=0
	return a


for __ in range(int(input())):
	n=int(input())
	arr=[[]]*n
	for i in range(n):arr[i]=I()
	if arr[0][0]<arr[0][1]:
		print("NO")
		continue
	f=1
	for i in range(1,n):
		if not (arr[i][0]>=arr[i-1][0] and arr[i][1]>=arr[i-1][1] and (arr[i][1]-arr[i-1][1])<=(arr[i][0]-arr[i-1][0]) and arr[i][0]>=arr[i][1]):
			print("NO")
			f=0
			break
	if f:print("YES")


