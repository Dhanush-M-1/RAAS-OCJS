# AOJ 0524: Searching Constellation
# Python3 2018.7.1 bal4u

def check(dx, dy):
	f = True
	for x, y in goal:
		if (x+dx, y+dy) not in tbl: 
			f = False
			break
	return f

while True:
	m = int(input())
	if m == 0: break
	goal, star, tbl = [], [], {}
	for i in range(m):
		goal.append(tuple(map(int, input().split())))
	for i in range(int(input())):
		x, y = map(int, input().split())
		star.append((x, y))
		tbl[x,y] = 1
	for x, y in star:
		dx, dy = x-goal[0][0], y-goal[0][1]
		if check(dx, dy): break
	print(dx, dy)
