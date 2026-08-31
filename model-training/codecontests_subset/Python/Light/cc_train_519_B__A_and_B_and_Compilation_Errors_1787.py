n = int(input())
map_e = {}
for x in input().split():
	try:
		map_e[x] += 1
	except KeyError:
		map_e[x] = 1

def find_e(map_e):
	map_n_e = {}
	for x in input().split():
		try:
			map_n_e[x] += 1
		except KeyError:
			map_n_e[x] = 1


	for k, v in map_e.items():
		if k not in map_n_e or map_n_e[k] != v:
			a = k
			break
	return a, map_n_e


a, map_e = find_e(map_e)
b, map_e = find_e(map_e)

print(a)
print(b)
