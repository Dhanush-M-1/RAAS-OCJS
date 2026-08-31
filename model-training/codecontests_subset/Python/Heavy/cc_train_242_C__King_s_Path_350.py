from collections import deque, defaultdict

def bfs(x, y, x_dest, y_dest, allowed):
	visit_time = dict()
	fringe = deque()
	fringe.append((x, y))
	visit_time[(x,y)] = 0

	while len(fringe):
		x, y = fringe.popleft()
		if (x, y) == (x_dest, y_dest):
			return visit_time[(x, y)]

		for i in range(-1,2):
			for j in range(-1,2):
				if (x+i, y+j) not in visit_time and allowed[(x,y)]:
					fringe.append((x+i, y+j))
					visit_time[((x+i),(y+j))] = visit_time[(x, y)] + 1 

		

	return -1					
if __name__ == '__main__':
	x_init, y_init, x_fin, y_fin = map(int, input().split())
	n = int(input())
	allowed = defaultdict(lambda: False)

	for i in range(n):
		r, a, b = map(int, input().split())
		
		for j in range(a, b+1):
			allowed[(r,j)] = True

	print(bfs(x_init, y_init, x_fin, y_fin, allowed))