import io
import os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
n, m = map(int, input().split())
tmp = map(lambda x: int(x)-1, input().split())
ls,pointer = [0]*n, [0]*n # ls = ind -> val, pointer = val -> ind
for i,l in enumerate(tmp):
	ls[i] = l
	pointer[l] = i
# print(ls)
options = [0]*n # val -> # of elements swappable
dependencies = [[] for i in range(n)] # val -> [val1,  ..] where (val, val1)
for _ in range(m):
	i, j = map(lambda x: int(x)-1, input().split())
	if pointer[i] < pointer[j]: # thus element i is left from element j
		dependencies[j].append(i)
		options[i]+=1
important = n-1
# print(options, dependencies)
for i in range(n-2, -1, -1):
	val = ls[i]
	nrskip = options[val]
	if important == i + nrskip:
		for d in dependencies[val]: options[d] -=1
		important-=1
print(n-important-1)
# while n-1 in range(