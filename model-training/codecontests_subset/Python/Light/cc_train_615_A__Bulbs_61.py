#codeforces615A
gi = lambda : list(map(int,input().strip().split()))
n,m = gi()
occ = [0]*(m+1)
for k in range(n):
	for e in gi()[1:]:
		occ[e] += 1
print("YNEOS"[0 in occ[1:]::2])
