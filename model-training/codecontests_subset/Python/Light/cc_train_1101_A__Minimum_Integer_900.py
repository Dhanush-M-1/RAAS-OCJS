t=int(input())
while(t>0):
	l,r,d = [int(x) for x in input().split()]
	if d<l:
		print(d)
	else:
		t1=r%d
		print(r+d-t1)
	t-=1