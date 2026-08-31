def bulbs(n,m,seq):
	ySet = set()

	for l in seq:
		s = list(l)
		x = s[0]
		i=1
		while i<=x:
			ySet.add(s[i])
			i+=1
	
	if len(ySet) == m:
		return "YES"
	else:
		return "NO"

n,m = [int(x) for x in input().split()]
seq=[]

while(n>0):
	seq.append(int(x) for x in input().split())
	n-=1

print(bulbs(n,m,seq))