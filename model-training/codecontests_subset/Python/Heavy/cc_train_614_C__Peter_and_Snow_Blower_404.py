def dis(lx,ly):
	return (lx)*(lx)+(ly)*(ly)
def linecoeff(lx,ly,rx,ry):
	return (ry-ly, lx-rx, -lx*ry+ly*rx)

from math import *
n, px, py = map(int, input().split())
a = [[0,0] for i in range(n)]
minlen = 100000000000000
maxlen = 0
for i in range(n):
	x, y = map(float, input().split())
	x-=px
	y-=py
	a[i][0],a[i][1] = x, y
	#a.append([x,y])
	l = x*x+y*y
	maxlen = max(maxlen, l)
a.append([a[0][0],a[0][1]])

for i in range(n):
	#print(a)
	lx, ly = a[i][0], a[i][1]
	rx, ry = a[i+1][0], a[i+1][1]
	A,B,C=linecoeff(lx,ly,rx,ry)
	#print(lx,ly,rx,ry)
	DL = sqrt(A*A+B*B)
	A,B,C = A/DL, B/DL, C/DL
	ddd = C
	tx = -ddd*A
	ty = -ddd*B
	#print(tx,ty)
	l = dis(tx,ty)
	#while dis(lx-rx,ly-ry,)>1e-10:
	#	m1x = lx+(rx-lx)/3
	#	m1y = ly+(ry-ly)/3
	#	m2x = lx+2*(rx-lx)/3
	#	m2y = ly+2*(ry-ly)/3
	#	if dis(m1x,m1y)<dis(m2x,m2y):
	#		rx = m2x
	#		ry = m2y
	#	else:
	#		lx = m1x
	#		ly = m1y
	#minlen = min(minlen, dis(lx,ly))
	l = dis(tx,ty)
	if (lx<=tx<=rx or rx<=tx<=lx) and (ly<=ty<=ry or ry<=ty<=ly):
		minlen = min(minlen, l)
	l = dis(lx,ly)
	minlen = min(minlen, l)
print(pi*(maxlen-minlen))
