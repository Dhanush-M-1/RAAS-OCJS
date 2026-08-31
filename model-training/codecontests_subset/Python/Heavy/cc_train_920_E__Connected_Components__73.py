def read_int():
	return int(input())

def read_str():
	return input()

def read_list(type=int):
	return list(map(type, input().split()))

def print_list(x):
	print(len(x), ' '.join(map(str, x)))

# ------------------------------------------------------


N = 200123
nbs = [[] for i in range(N)]
up = [i for i in range(N)]
sz = [1] * N

def find(v):
	if v == up[v]:
		return v
	up[v] = find(up[v])
	return up[v]

def join(v, w):
	v = find(v)
	w = find(w)
	if v == w:
		return
	if sz[v] < sz[w]:
		v, w = w, v
	up[w] = v
	sz[v] += sz[w]

def main():
	n, m = read_list()
	for i in range(m):
		a, b = read_list()
		a, b = a-1, b-1
		if a < b:
			a, b = b, a
		nbs[a].append(b)

	components = set()
	for v in range(n):
		nonedges = dict()
		for w in nbs[v]:
			w = find(w)
			nonedges[w] = nonedges[w] + 1 if w in nonedges else 1
		tojoin = []
		for c in components:
			c = find(c)
			if nonedges.get(c, 0) < sz[c]:
				tojoin.append(c)
		for j in tojoin:
			join(j, v)
			components.remove(j)
		components.add(find(v))

	res = sorted([sz[find(c)] for c in components])
	print(len(res))
	for r in res:
		print(r, end=' ')

if __name__ == '__main__':
	main()