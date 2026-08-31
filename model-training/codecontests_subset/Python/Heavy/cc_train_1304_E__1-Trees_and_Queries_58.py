import sys

n = int(input())

g = [[] for _ in range(n)]
t_in = [-1 for _ in range(n)]
t_out = [-1 for _ in range(n)]
height = [-1 for _ in range(n)]

time = 0

k = 0
while (2 ** k) <= n: 
	k += 1

up = [[0 for j in range(k + 1)] for i in range(n)]

def upper(a, b):
	return t_in[a] <= t_in[b] and t_out[a] >= t_out[b]

def lca(v, u):
	# if (upper(a, b)):
	# 	return a

	# if upper(b, a):
	# 	return b

	# i = k
	# while i >= 0:
	# 	if not upper(up[a][i], b):
	# 		a = up[a][i]
	# 	i -= 1

	# #print('lca k = ', k)
	# return up[a][i]

	if height[v] > height[u]:
		u, v = v, u

	for i in reversed(range(k + 1)):
		if height[up[u][i]] - height[v] >= 0:
			u = up[u][i]

	if u == v:
		return u

	for i in reversed(range(k + 1)):
		if up[v][i] != up[u][i]:
			v = up[v][i]
			u = up[u][i]

	return up[v][0]

def dist(a, b):
	p = lca(a, b)	
	result = (height[a] - height[p]) + (height[b] - height[p]) 
	#print('dist', a, b, 'lca = ', p, 'res = ', result)
	return result

def dfs(v, p, depth):
	time = 0
	stack = [(v, p, depth)]
	while len(stack) > 0:
		x = stack.pop()
		if len(x) == 1:
			t_out[x[0]] = time 
			time += 1
			continue 

		v, p, depth = x
		t_in[v] = time
		time += 1
		height[v] = depth

		up[v][0] = p
		for i in range(1, k + 1):
			up[v][i] = up[up[v][i-1]][i - 1]

		stack.append([v])
		for w in g[v]:
			if t_in[w] == -1:
				stack.append((w, v, depth + 1))

def check(dist, k):
	#print('check', dist, k)
	return dist <= k and ((dist % 2) == (k % 2))

for i in range(n - 1):
	a, b  = map(int, input().split())
	a -= 1
	b -= 1
	g[a].append(b)
	g[b].append(a)

dfs(0, 0, 0)

#print(height)
#print(t_in)
#print(t_out)
#print(upper(8, 5))

m = int(input())
for i in range(m):
	x, y, a, b, q = map(lambda x: int(x) - 1, input().split())
	#print(x, y, a, b, q)
	q = q + 1
	dist1 = dist(a, b)
	if check(dist1, q):
		print("YES")
		continue

	dist2 = dist(a, x) + 1 + dist(y, b)
	if check(dist2, q):
		print("YES")
		continue

	dist3 = dist(a, y) + 1 + dist(b, x)
	if check(dist3, q):
		print("YES")
	else:
		print("NO")

