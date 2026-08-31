n = int(input())
l = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j"]
a = []
def h(i, s, t):
	if i == 0:
		a.append(s)
		print(s)
	else:
		for j in range(t+1):
			ns = s+l[j]
			nt = max([j+1, t])
			h(i-1, ns, nt)
h(n, "", 0)