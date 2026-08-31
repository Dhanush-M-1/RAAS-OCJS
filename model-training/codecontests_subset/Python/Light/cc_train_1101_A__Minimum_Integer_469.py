import math
q=int(input())
for tt in range(q):
	l,r,d=map(int,input().split())
	if d==1:
		if l>1:
			print(1)
		else:
			print(r+1)
		continue
	if d>r:
		print(d)
		continue
	if d<l:
		print(d)
		continue
	if l>d:
		xx=(r//d)
		print(xx*d)
		continue
	yy=math.floor(l/d)
	xx=math.ceil(r/d)
	lx=yy*d 
	rx=xx*d 
	if lx==l:
		lx=(yy-1)*d 
	if rx==r:
		rx=(xx+1)*d 
	if lx<=0:
		lx=1000000000000
	print(min(lx,rx))