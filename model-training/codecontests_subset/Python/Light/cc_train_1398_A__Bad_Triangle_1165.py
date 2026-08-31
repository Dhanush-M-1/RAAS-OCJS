for _ in range(int(input())):
	N=int(input())
	array=[int(x) for x in input().split()]
	if array[0]+array[1]<=array[-1]:
		print(1,2,N)
	else:
		print(-1)