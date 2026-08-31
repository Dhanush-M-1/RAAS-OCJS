def euclid(a, b):
	if b==0:
		return (1,0)
	x0, y0 = euclid(b, a%b)
	return (y0, x0 - divs(a,b)*y0)

def gcd(a,b):
	return gcd(b, a%b) if b != 0 else a


def divs(a, b):
	return a//b if a*b>0 else (a+(-a%b))//b

n, p, w, d = map(int, input().split())
g = gcd(w,d)
if p%g != 0:
	print(-1)
	exit(0)

x0, y0 = euclid(w,d)
x0 *= divs(p,g)
y0 *= divs(p,g)
num = (n-x0-y0)*g
den = d-w
kmin1 = (divs(num,den)+1 if divs(num,den) >= 0 else divs(num,den)) if num%den != 0 else divs(num,den)

num = -x0*g;
den = d;
kmin2 = (divs(num,den)+1 if divs(num,den) >= 0 else divs(num,den)) if num%den != 0 else divs(num,den)

num = y0*g;
den = w;

# prdivs('num= ', num)
# prdivs('den= ', den)
# prdivs('divs(num,den)= ', divs(num,den))

# prdivs('kmin1', kmin1)
# prdivs('kmin2', kmin2)

kmax = (divs(num,den) if divs(num,den) >= 0 else divs(num,den)-1) if num%den != 0 else divs(num,den)

# prdivs('kmax',kmax)

k = kmin1 if kmin1 > kmin2 else kmin2

# prdivs('k= ', k)
# prdivs('kmax= ', kmax)

if k>kmax:
	print(-1)
	exit(0)

x = x0 + divs((d*k),g)
y = y0 - divs((w*k),g)
z = n-x-y

print(str(x) + ' ' + str(y) + ' ' + str(z))