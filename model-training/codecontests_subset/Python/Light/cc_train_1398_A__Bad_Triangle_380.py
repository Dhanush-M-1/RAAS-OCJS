tc = int(input())
for _ in range(tc):
	n = int(input())
	arr = list(map(int, input().split()))
	A,B = arr[0], arr[1]
	f = 1
	for i in range(2, n):
		C = arr[i]
		if(A+B <= C or B + C <= A or C + A <= B):
			print(1, 2, i+1)
			f = 0
			break
	if(f):
		print(-1)