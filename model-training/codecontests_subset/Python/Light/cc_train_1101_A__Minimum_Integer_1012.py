q = int(input())

for qi in range(q):
	li, ri, di = map(int, input().split())

	if di < li:
		print(di)

	else:
		print((ri // di + 1) * di)
