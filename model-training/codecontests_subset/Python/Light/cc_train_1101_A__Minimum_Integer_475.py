t = int(input())
for _ in range(t):
	l,r,d = map(int,input().split())
	if d>=l and d<=r:
		print(((r//d)+1)*d)
	else :
		print(d)