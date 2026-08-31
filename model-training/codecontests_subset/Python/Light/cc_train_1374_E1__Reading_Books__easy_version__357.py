from sys import stdin
ip=stdin.readline
n,k=map(int, ip().split())
alike=[]; blike=[]; both=[]
for _ in range(n):
	t,a,b=map(int, ip().split())
	if a and b: both.append(t)
	elif a: alike.append(t)
	elif b: blike.append(t)
lb=k-len(both); aln=len(alike); bln=len(blike)
if aln<lb or bln<lb: print('-1')
else:
	alike.sort(); blike.sort()
	both += [alike[i] + blike[i] for i in range(min(aln,bln))]
	both.sort()
	print(sum(both[:k:]))