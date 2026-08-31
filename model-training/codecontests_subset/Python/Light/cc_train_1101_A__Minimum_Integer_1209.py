q=int(input())
for i in range(q):
	l,r,d = map(int, input().split())
	#print(l,r,d)
	if d<l or d>r:
		print(d)
	else:
		a= (r - (r%d)) +d
		print(a)