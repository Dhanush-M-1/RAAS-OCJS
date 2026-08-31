# -*- coding: utf-8 -*-
# @Author: DarkDawn
# @Date:   2019-10-14 19:12:55
# @Last Modified by:   DarkDawn
# @Last Modified time: 2019-10-14 19:25:08

def exgcd( a, b, x, y ):
	if b == 0:
		x[0] = 1
		y[0] = 0
		return a
	d = exgcd( b, a%b, x, y )
	t = x[0]
	x[0] = y[0]
	y[0] = t-(a//b)*y[0]
	return d

n,p,w,d = input().split(" ")
n = int(n)
p = int(p)
w = int(w)
d = int(d)
x = [0]
y = [0]
gcd = exgcd( w, d, x, y )
if p%gcd != 0:
	print("-1")
else:
	tmp = p//gcd
	w0 = w//gcd
	d0 = d//gcd
	xx = x[0]*tmp
	yy = y[0]*tmp
	# print(str(xx)+" "+str(yy))
	if yy < 0:
		tm = (-yy+w0-1)//w0
		yy = yy+w0*tm
		xx = xx-d0*tm
	tm = yy//w0
	yy = yy-tm*w0
	xx = xx+tm*d0
	# print(str(xx)+" "+str(yy))
	if xx < 0 or xx+yy > n:
		print("-1")
	else:
		print(str(xx)+" "+str(yy)+" "+str(n-xx-yy)) 