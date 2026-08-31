nums = input().split()
bulbs = []
det = 1
n = int(nums[0])
m = int(nums[1])
for i in range(n):
	xy = input().split()
	bulbs.extend(xy[1:])
for j in range(1,m+1):
	if bulbs.count(str(j)) == 0:
		det*=0
if det == 0:
	print("NO")
else:
	print("YES")
