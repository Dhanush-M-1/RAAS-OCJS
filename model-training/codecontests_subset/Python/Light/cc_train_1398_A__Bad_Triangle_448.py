for t in range(int(input())):
	n = int(input())
	li = [int(x) for x in input().split()]
	if li[0]+li[1]<=li[-1]:
		print(1,2,n)
	else:
		print(-1)
