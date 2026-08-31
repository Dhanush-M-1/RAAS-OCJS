'''Pranet Verma'''
import queue
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
n, m, k = [int(x) for x in input().split()]
s = []
[s.append(input()) for i in range(n)]
vis = [[False for x in range(m)] for y in range(n)]

left = -k
for i in range(n):
	left = left + s[i].count('.')

for i in range(n):
	done = False
	for j in range(m):
		if s[i][j] == '.':
			q = queue.Queue()
			vis[i][j] = True
			left = left - 1
			q.put((i, j))

			while not q.empty():
				x, y = q.get()
				for i in range(4):
					if left <= 0:
						break
					nx = x + dx[i]
					ny = y + dy[i]
					if nx >= 0 and nx < n and ny >= 0 and ny < m:
						if not vis[nx][ny] and s[nx][ny] == '.':
							vis[nx][ny] = True
							left = left - 1
							q.put((nx, ny))
			done = True
			break
	if done:
		break

for i in range(n):
	for j in range(m):
		if s[i][j] == '.' and not vis[i][j]:
			print ('X', end='')
		else:
			print (s[i][j], end='')
	print('\n', end='')