n = int(input())
con = []
for i in range(n):
	nums = input().split(' ')
	con.append([int(nums[0]), int(nums[1]), int(nums[2])])
res = []
for i in con:
	if i[0] > i[2] or i[1] < i[2]:
		res.append(i[2])
	else:
		res.append(((i[1] // i[2]) + 1) * i[2])
for i in res:
	print(i)