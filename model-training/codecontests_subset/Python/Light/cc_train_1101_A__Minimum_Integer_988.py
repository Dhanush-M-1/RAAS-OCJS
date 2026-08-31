n = int(input())
for i in range(n):
	l,r,d=map(int,input().split());
	if l>d or r<d :
		print(d)
	else :
		print(r+d-(r%d));