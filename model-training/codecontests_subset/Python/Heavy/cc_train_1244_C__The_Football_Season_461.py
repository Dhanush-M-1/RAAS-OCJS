def egcd(a,b):
	if b == 0:
		return (a,(1,0))
	tmp = egcd(b,a%b)
	return (tmp[0],(tmp[1][1],tmp[1][0]-tmp[1][1]*(a//b)))

foo = [int(x) for x in input().split()]
n = foo[0]
p = foo[1]
w = foo[2]
d = foo[3]
euclid = egcd(w,d)
g = euclid[0]
if p%g:
	print(-1)
else:
	x = euclid[1][0]*(p//g)
	y = euclid[1][1]*(p//g)
	if x <= 0:
		diff = y
		k = (g*diff)//w
		while y-k*(w//g) > 0:
			k += 1
		while y-k*(w//g) < 0:
			k -= 1
		x += k*(d//g)
		y -= k*(w//g)
	elif y <= 0:
		diff = -y
		k = (g*diff)//w
		while y+k*(w//g) > 0:
			k -= 1
		while y+k*(w//g) < 0:
			k += 1
		x -= k*(d//g)
		y += k*(w//g)
	if x < 0 or y < 0 or x+y > n:
		print(-1)
	else:
		print(str(x)+' '+str(y)+' '+str(n-(x+y)))
