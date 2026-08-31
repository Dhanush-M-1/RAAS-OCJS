n = int(input())
lis = []
for i in range(n):
	x, h = map(int, input().split())
	lis.append([x, h])
count = 2
for i in range(1, len(lis) - 1):
	if lis[i][1] < lis[i][0] - lis[i - 1][0]:
		count += 1
	elif lis[i][1] + lis[i][0] < lis[i + 1][0]:
		count += 1 
		lis[i][0] =  lis[i][1] + lis[i][0] 
if n == 1:
	print(1)
elif n == 2:
	print(2)
else:
	print(count)