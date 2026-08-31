lastx = -float('inf')
okdone = 0

task = [tuple(map(int, input().split())) for i in range(int(input()))] + [(float('inf'), float('inf'))]
for i in range(len(task)-1):
	a, b = task[i]
	if a-b>lastx:
		lastx = a
		okdone += 1

	elif a+b < task[i+1][0]:
		lastx = a+b
		okdone += 1
	else:
		lastx = a


print(okdone)
