path = [0]*1000000
n = int(input())
points = str(input()).split()

for point in points:
	point = int(point)
	path[point-1] = 1

current = 500000-1
answer1 = 0
answer2 = 0
while current < 1000000:
	if path[current] == 1:
		answer1 = 1000000 - current - 1
		break
	current = current + 1

current = 500000-1
while current >= 0:
	if path[current] == 1:
		answer2 = current
		break
	current = current - 1 

if max(answer1, answer2) == 500000:
	print(499999)
else :
	print(max(answer1, answer2))