query=int(input())

for _ in range(query):
	n = int(input())
	a = list(map(int, input().split()))
	ma = max(a);mi = min(a)
	flag=0
	for i in range(1, n-1):
		if a[0]+a[i]<=a[n-1]:
			#As sum of two sides of a trinagle is always greater than the third
			flag=1
			break
	if flag==1:
		#Bcz of the array being sorted, if the least and other element sum becomes less than max, there will be no triangle 
		print(1, i+1, n)
	else:
		print(-1)