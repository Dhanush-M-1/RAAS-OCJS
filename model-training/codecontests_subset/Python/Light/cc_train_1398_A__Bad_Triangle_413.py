for i in range(int(input())):
	n = int(input())
	ar = list(map(int,input().split()))
	if ar[0]+ar[1]>ar[-1]:
	     print("-1")
	else:
	     print("1","2",n)