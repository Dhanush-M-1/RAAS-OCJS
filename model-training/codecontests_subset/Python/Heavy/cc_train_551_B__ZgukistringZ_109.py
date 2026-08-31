def ci(c):
	return ord(c) - 97

def ic(i):
	return chr(i + 97)

a, b, c = input(), input(), input()
ina = 26*[0]
for i in a:
	ina[ci(i)] += 1
inb = 26*[0]
for i in b:
	inb[ci(i)] += 1
inc = 26*[0]
for i in c:
	inc[ci(i)] += 1
bl = 26*[10**7]
for i in range(26):
	if inb[i] != 0:
		bl[i] = ina[i]//inb[i]
blmin = min(bl)
best = 0
best_val = (0, 0)
for nb in range(blmin + 1):
	inac = ina[:]
	for i in range(26):
		inac[i] -= inb[i]*nb
		assert inac[i] > -1
	cl = 26*[10**7]
	for i in range(26):
		if inc[i] != 0:
			cl[i] = inac[i]//inc[i]
	clmin = min(cl)
	if nb + clmin > best:
		best = nb + clmin
		best_val = (nb, clmin)
for i in b:
	ina[ci(i)] -= best_val[0]
for i in c:
	ina[ci(i)]-= best_val[1]
s = ''
for i in range(26):
	s += ic(i)*ina[i]
print(best_val[0]*b + best_val[1]*c + s)