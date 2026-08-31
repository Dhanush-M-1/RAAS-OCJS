for _ in range(int(input())):
	x= int(input())
	ar = list(map(int , input().split()))
	if ar[len(ar)-1]>=(ar[0]+ar[1]):
		print(f'1 2 {len(ar)}')
	else:
		print(-1)