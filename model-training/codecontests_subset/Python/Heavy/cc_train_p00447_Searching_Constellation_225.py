# AOJ 0524: Searching Constellation
# Python3 2018.7.1 bal4u

def check(dx, dy):
	f = True
	for x, y in goal:
		if (x+dx, y+dy) not in star: 
			f = False
			break
	return f

while True:
	m = int(input())
	if m == 0: break
	goal, star = [], []
	for i in range(m):
		x, y = map(int, input().split())
		goal.append((x, y))
	for i in range(int(input())):
		x, y = map(int, input().split())
		star.append((x, y))
	for x, y in star:
		dx, dy = x-goal[0][0], y-goal[0][1]
		if check(dx, dy): break
	print(dx, dy)
