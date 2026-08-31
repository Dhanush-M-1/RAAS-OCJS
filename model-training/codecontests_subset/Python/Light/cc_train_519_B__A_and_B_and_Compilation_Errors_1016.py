p = 1
arr = [0, 0]
t = int(input())
dq = list(map(int, input().split()))
arr[0] = sum(dq)
while(p <= 2):
	dq = list(map(int, input().split()))
	arr[p % 2] = sum(dq)
	print(abs(arr[0] - arr[1]))
	p += 1
