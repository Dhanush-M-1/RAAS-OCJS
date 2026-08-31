def bulbs(n,m,seq):
	yList = []

	for l in seq:
		s = list(l)
		x = s[0]		
		yList.append(s[1:x+1])

	ySet = set()
	for item in yList:
		for  i in item:
   	 		ySet.add(i)

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