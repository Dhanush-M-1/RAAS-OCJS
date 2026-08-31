def ft():
	n = int(input())
	amax = None
	bmax = None
	amin = None
	bmin = None
	answer = 0
	for i in range(n):
		a, b = [int(s) for s in input().split()]
		if amax is None or a>amax:
			amax = a
#		elif bmax is None or b==bmax:
#			if a<amax:
#				amax = a
		if bmin is None or b<bmin:
			bmin = b
	#print("!", amax, bmin)
	if (amax is not None and bmin is not None) and amax>bmin:
		answer = amax-bmin
	
	return answer

t = int(input())
ans = ""
for i in range(t):
	ans+=str(ft())+'\n'
print(ans, end='')
