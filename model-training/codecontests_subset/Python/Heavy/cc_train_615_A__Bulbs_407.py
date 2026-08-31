n, m = map(int, input().split())
bulbs = [False]*m
for i in range(n):
	vals = input().split()
	for j in range(1,int(vals[0])+1):
		bulbs[int(vals[j])-1] = True
all_on = True
for l in bulbs:
	if l == False:
		all_on = False
if all_on:
	print("YES")
else:
	print("NO")
"""n, m = map(int, input().split())
lamps = [False]*m
for i in range(n):
	vals = input().split()
	for j in range(1, int(vals[0]) + 1):
		lamps[int(vals[j]) - 1] = True
all_on = True
for l in lamps:
	if l == False:
		all_on = False
if all_on:
	print('YES')
else:
	print('NO')"""