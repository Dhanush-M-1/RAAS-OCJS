exec("""
from queue import PriorityQueue

INF = 1000000

n = int(input())
g = [[int(x) fo"""+"""r x in input().split()] fo"""+"""r _ in range(n)]

diam = 0
fo"""+"""r start in range(n):
	d = [INF fo"""+"""r i in range(n)]
	q = PriorityQueue()
	q.put((0, start))

	whi"""+"""le not q.empty():
		dist, i = q.get()
		i"""+"""f d[i] != INF:
			continue
		# print("get", dist, i)
		d[i] = dist
		fo"""+"""r j in range(n):
			# print("put", d[i] + g[i][j], j)
			q.put((d[i] + g[i][j], j))

	diam = max(diam, max(d))
	# print(d)

print(diam)
""")