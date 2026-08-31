num  = int(input())
init = [int(x) for x in input().split()]
d = {}
cone = [int(x) for x in input().split()]
for i in cone:
	if i not in d:
		d[i] = 0
	d[i] += 1
for i in init:
	if i in d and d[i] > 0:
		d[i] -= 1
	else:
		print(i)
		break
ctwo = [int(x) for x in input().split()]
d = {}
for i in ctwo:
	if i not in d:
		d[i] = 0
	d[i] += 1
for i in cone:
	if i in d and d[i] > 0:
		d[i] -= 1
	else:
		print(i)
		break