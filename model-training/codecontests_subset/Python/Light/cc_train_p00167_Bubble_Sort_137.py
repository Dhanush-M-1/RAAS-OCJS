# AOJ 0167 Bubble Sort
# Python3 2018.6.20 bal4u

while True:
	n = int(input())
	if n == 0: break
	a = [0]*105
	for i in range(n): a[i] = int(input())
	cnt = 0
	for i in range(n-1, 0, -1):
		for j in range(i):
			if a[j] > a[j+1]:
				cnt += 1
				a[j], a[j+1] = a[j+1], a[j]
	print(cnt)

