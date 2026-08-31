# for _ in range(int(input())):
n = int(input())
# n, m = map(int, input().split())
l = list(map(int, input().split()))
# l = [list(map(int, input().split())) for i in range(n)]

if n == 1:
	print(1, 1)
	print(0)
	print(1, 1)
	print(0)
	print(1, 1)
	print(-l[0])

else:
	print(1, n)
	arr = []
	for i in range(n):
		arr.append(-l[i]*n)
	print(*arr)

	arr2 = []
	print(1, n-1)
	for i in range(n-1):
		arr2.append(l[i]*(n-1))
	print(*arr2)

	print(n, n)
	print(l[-1]*(n-1))


	# print(1,1)
	# print(-l[0])
	# l[0] = 0
	# print(2, n)

	# valarr = []
	# for i in range(1, n):
	# 	temp = n-1
	# 	val = (l[i]%n)*temp
	# 	l[i]+=val
	# 	valarr.append(val)
	# print(*valarr)

	# print(1, n)
	# arr = []
	# for i in range(n):
	# 	arr.append(-l[i])
	# print(*arr)